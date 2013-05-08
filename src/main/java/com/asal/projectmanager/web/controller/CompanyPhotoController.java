package com.asal.projectmanager.web.controller;

import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.renderable.ParameterBlock;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import javax.media.jai.JAI;
import javax.media.jai.OpImage;
import javax.media.jai.RenderedOp;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.coobird.thumbnailator.Thumbnails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

import com.asal.projectmanager.dao.ProjectUserDao;
import com.asal.projectmanager.domain.Company;
import com.asal.projectmanager.domain.CompanyPhoto;
import com.asal.projectmanager.domain.Photo;
import com.asal.projectmanager.domain.ProjectUser;
import com.asal.projectmanager.service.CompanyPhotoService;
import com.asal.projectmanager.service.CompanyService;
import com.asal.projectmanager.service.PhotoService;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.sun.media.jai.codec.SeekableStream;

@Controller
public class CompanyPhotoController {

	/**
	 * this gets rid of exception for not using native acceleration
	 */
	static {
		System.setProperty("com.sun.media.jai.disableMediaLib", "true");
	}

	/**
	 * The JAI.create action name for handling a stream.
	 */
	private static final String JAI_STREAM_ACTION = "stream";

	/**
	 * The JAI.create action name for handling a resizing using a subsample
	 * averaging technique.
	 */
	private static final String JAI_SUBSAMPLE_AVERAGE_ACTION = "SubsampleAverage";

	/**
	 * The JAI.create encoding format name for JPEG.
	 */
	private static final String JAI_ENCODE_FORMAT_JPEG = "JPEG";

	/**
	 * The JAI.create action name for encoding image data.
	 */
	private static final String JAI_ENCODE_ACTION = "encode";

	/**
	 * The http content type/mime-type for JPEG images.
	 */
	private static final String JPEG_CONTENT_TYPE = "image/jpeg";

	private int mMaxWidth = 800;

	private int mMaxWidthThumbnail = 150;

	private final int DEFAULT_BUFFER_SIZE = 10240; // 10kb

	@Autowired
	CompanyPhotoService companyPhotoService;
	@Autowired
	PhotoService photoService;
	@Autowired
	CompanyService companyService;
	
	@Autowired
	ProjectManagerSession projectMangerSession;
	
	@Autowired
	ProjectUserDao projectUserDao;


	@RequestMapping(value = "/companyphotos/{companyId}", method = RequestMethod.GET)
	public String listPhotos(@PathVariable("companyId") Long companyId, Model model) {
		//@ModelAttribute("companyPhoto") CompanyPhoto companyPhoto, 
		Company company =  companyService.findById(companyId);
//		Long profilePhotoId = null;
		
//		profilePhotoId = photoService.getProfilePhotoId(projectMangerSession.getUser().getId());
		List<CompanyPhoto> listCompanyPhoto = companyPhotoService.findByCompany(company);
		//List<Photo> photoList = photoService.listPhoto();
		model.addAttribute("photo", new CompanyPhoto());
		model.addAttribute("listCompanyPhoto", listCompanyPhoto);
		//model.addAttribute("companyPhoto", new CompanyPhoto());
		//model.addAttribute("photoList", photoList);
		model.addAttribute("company", company);
//		model.addAttribute("profilephotoId", profilePhotoId);

		return "companyphoto";
	}

	@RequestMapping(value = "/addCompanyPhoto/{companyId}", method = RequestMethod.POST)
	public String addPhoto(@RequestParam("file") MultipartFile file, @ModelAttribute("photo") CompanyPhoto photo,  @PathVariable("companyId") Long companyId) {
		Company company = companyService.findById(companyId);
		
		if (!file.isEmpty())
			companyPhotoService.addPhoto(company, file);
			//photoService.addPhoto(file);
		
		CompanyPhoto companyPhoto = null;
		String photoName = file.getOriginalFilename();
		
		companyPhoto = companyPhotoService.getPhoto(photoName);
		
		company.setCompanyPhoto(companyPhoto);
		companyService.update(company);
		
		
		
		try {
			Thumbnails.of(companyPhoto.getContent().getBinaryStream()).size(70, 50).toFile(new File("thumbnail"+companyPhoto.getName()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//InputStream thumbStream = null;
		File thumbFile = null;
		String thumbnailname = "thumbnail"+companyPhoto.getName();
		companyPhoto.setThumbnailname(thumbnailname);
		thumbFile = new File(thumbnailname);
		//thumbFile.le
		
		companyPhotoService.addThumbNail(companyPhoto, thumbFile);
		return "redirect:/companyphotos/"+companyId;
	}

	@RequestMapping(value = "/deleteCompanyPhoto/{photoId}")
	public String deletePhot(@PathVariable("photoId") Long id) {

		companyPhotoService.removePhoto(id);
		return "redirect:/companyphotos";
	}
	
	//
	
	@RequestMapping(method = RequestMethod.POST, value = "/companyphotoEdit/{id}")
	public String editPhoto(Model model, @PathVariable("id") Long photoId, @ModelAttribute("companyPhoto") CompanyPhoto companyPhoto,
			HttpServletResponse response) throws ServletException, IOException {

		// Check if id is supplied to the request
		if (photoId == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404
			return null;
		}

		CompanyPhoto originalPhoto = companyPhotoService.getPhoto(photoId);

		if (originalPhoto == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		
		originalPhoto.setNewname(companyPhoto.getNewname());
		originalPhoto.setIsDefault(companyPhoto.getIsDefault());
		originalPhoto.setIsProfilePhoto(companyPhoto.getIsProfilePhoto());
		
		//Update the user to set the profilephotoid
		ProjectUser projectUser = projectUserDao.findOne(originalPhoto.getCreatedBy().getId());
		projectUser.setProfilePhotoId(originalPhoto.getId());
		projectUserDao.update(projectUser);
		
		
		
		companyPhotoService.updatePhoto(originalPhoto);

		return "redirect:/companyphotos";

	}

	@RequestMapping(method = RequestMethod.GET, value = "/companyphoto/{id}")
	public void getPhoto(Model model, @PathVariable("id") Long photoId,
			HttpServletResponse response) throws ServletException, IOException {

		// Check if id is supplied to the request
		if (photoId == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404
			return;
		}

		CompanyPhoto companyPhoto = companyPhotoService.getPhoto(photoId);

		if (companyPhoto == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		// Init Servlet response

		response.reset();
		response.setBufferSize(DEFAULT_BUFFER_SIZE);
		response.setContentType(companyPhoto.getContentType());
		response.setHeader("Content-Length", String.valueOf(companyPhoto.getLength()));
		response.setHeader("Content-Disposition",
				"inline; filename=\"" + companyPhoto.getName() + "\"");

		// Prepare streams.
		BufferedInputStream input = null;
		BufferedOutputStream output = null;

		try {
			// Open streams.
			try {
				input = new BufferedInputStream(companyPhoto.getContent()
						.getBinaryStream(), DEFAULT_BUFFER_SIZE);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			output = new BufferedOutputStream(response.getOutputStream(),
					DEFAULT_BUFFER_SIZE);

			// Write file contents to response.
			byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
			int length;
			while ((length = input.read(buffer)) > 0) {
				output.write(buffer, 0, length);
			}
		} finally {
			// Gently close streams.
			close(output);
			close(input);
		}

	}

	// Thumbnail

	@RequestMapping(method = RequestMethod.GET, value = "/companyphotothumbnail/{id}")
	public void getPhotoThumbNail(Model model, @PathVariable("id") Long photoId,
			HttpServletResponse response) throws ServletException, IOException {

		// Check if id is supplied to the request
		if (photoId == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404
			return;
		}

		CompanyPhoto companyPhoto = companyPhotoService.getPhoto(photoId);

		if (companyPhoto == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		// Init Servlet response

		response.reset();
		response.setBufferSize(DEFAULT_BUFFER_SIZE);
		response.setContentType(companyPhoto.getContentType());
		response.setHeader("Content-Length", String.valueOf(companyPhoto.getThumbLength()));
		response.setHeader("Content-Disposition",
				"inline; filename=\"" + companyPhoto.getThumbnailname() + "\"");

		// Prepare streams.
		BufferedInputStream input = null;
		BufferedOutputStream output = null;

		try {
			// Open streams.
			try {
				input = new BufferedInputStream(companyPhoto.getThumbNailContent()
						.getBinaryStream(), DEFAULT_BUFFER_SIZE);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			output = new BufferedOutputStream(response.getOutputStream(),
					DEFAULT_BUFFER_SIZE);

			// Write file contents to response.
			byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
			int length;
			while ((length = input.read(buffer)) > 0) {
				output.write(buffer, 0, length);
			}
		} finally {
			// Gently close streams.
			close(output);
			close(input);
		}
	}

	public String resolveException(HttpServletRequest request,
			HttpServletResponse response, Model model, Exception exception) {
		if (exception instanceof MaxUploadSizeExceededException) {
			model.addAttribute(
					"errors",
					"File size should be less then "
							+ ((MaxUploadSizeExceededException) exception)
									.getMaxUploadSize() + " byte.");
		} else {
			model.addAttribute("errors",
					"Unexpected error: " + exception.getMessage());
		}
		//model.addAttribute("companyPhoto", new CompanyPhoto());
		//model.addAttribute("listCompanyPhoto", companyPhotoService.listPhoto());

		return "companyphotos";
	}

	// Helper (can be refactored to public utility class)
	private static void close(Closeable resource) {
		if (resource != null) {
			try {
				resource.close();
			} catch (IOException e) {
				// Do your thing with the exception. Print it, log it or mail
				// it.
				e.printStackTrace();
			}
		}
	}

	/**
	 * This method takes in an image as a byte array (currently supports GIF,
	 * JPG, PNG and possibly other formats) and resizes it to have a width no
	 * greater than the pMaxWidth parameter in pixels. It converts the image to
	 * a standard quality JPG and returns the byte array of that JPG image.
	 * 
	 * @param pImageData
	 *            the image data.
	 * @param pMaxWidth
	 *            the max width in pixels, 0 means do not scale.
	 * @return the resized JPG image.
	 * @throws IOException
	 *             if the image could not be manipulated correctly.
	 */
	public byte[] resizeImageAsJPG(byte[] pImageData, int pMaxWidth)
			throws IOException {
		InputStream imageInputStream = new ByteArrayInputStream(pImageData);
		// read in the original image from an input stream
		SeekableStream seekableImageStream = SeekableStream.wrapInputStream(
				imageInputStream, true);
		RenderedOp originalImage = JAI.create(JAI_STREAM_ACTION,
				seekableImageStream);
		((OpImage) originalImage.getRendering()).setTileCache(null);
		int origImageWidth = originalImage.getWidth();
		// now resize the image
		double scale = 1.0;
		if (pMaxWidth > 0 && origImageWidth > pMaxWidth) {
			scale = (double) pMaxWidth / originalImage.getWidth();
		}
		ParameterBlock paramBlock = new ParameterBlock();
		paramBlock.addSource(originalImage); // The source image
		paramBlock.add(scale); // The xScale
		paramBlock.add(scale); // The yScale
		paramBlock.add(0.0); // The x translation
		paramBlock.add(0.0); // The y translation

		RenderingHints qualityHints = new RenderingHints(
				RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);

		RenderedOp resizedImage = JAI.create(JAI_SUBSAMPLE_AVERAGE_ACTION,
				paramBlock, qualityHints);

		// lastly, write the newly-resized image to an output stream, in a
		// specific encoding
		ByteArrayOutputStream encoderOutputStream = new ByteArrayOutputStream();
		JAI.create(JAI_ENCODE_ACTION, resizedImage, encoderOutputStream,
				JAI_ENCODE_FORMAT_JPEG, null);
		// Export to Byte Array
		byte[] resizedImageByteArray = encoderOutputStream.toByteArray();
		return resizedImageByteArray;
	}
	
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/companyphotoreduced/{id}")
	public void getPhotoReduced(Model model, @PathVariable("id") Long photoId,
			HttpServletResponse response) throws ServletException, IOException {
		
		Image image = null;

		// Check if id is supplied to the request
		if (photoId == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404
			return;
		}

		CompanyPhoto companyPhoto = companyPhotoService.getPhoto(photoId);

		if (companyPhoto == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		// Init Servlet response

		response.reset();
		response.setBufferSize(DEFAULT_BUFFER_SIZE);
		response.setContentType(companyPhoto.getContentType());
		response.setHeader("Content-Length", String.valueOf(companyPhoto.getLength()));
		response.setHeader("Content-Disposition",
				"inline; filename=\"" + companyPhoto.getName() + "\"");

		// Prepare streams.
		BufferedInputStream input = null;
		BufferedOutputStream output = null;
		
		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;
		
		
		try {
			// Open streams.
			try {
				input = new BufferedInputStream(companyPhoto.getContent()
						.getBinaryStream(), DEFAULT_BUFFER_SIZE);
				
				//Write to a file
				
				//fileInputStream = 
				//fileOutputStream =  new FileO
//				image = ImageIO.read(input);
//				ByteArrayOutputStream os = new ByteArrayOutputStream();
//				ImageIO.write((RenderedImage) image, photo.getContentType(), os);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				output = createThumbnail(companyPhoto.getName(), 150, 100, 1, companyPhoto.getName());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			output = new BufferedOutputStream(response.getOutputStream(),
					DEFAULT_BUFFER_SIZE);

			// Write file contents to response.
			byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
			int length;
			while ((length = input.read(buffer)) > 0) {
				output.write(buffer, 0, length);
			}
		} finally {
			// Gently close streams.
			close(output);
			close(input);
		}

	}
	
	
	private BufferedOutputStream createThumbnail(String filename, int thumbWidth, int thumbHeight, int quality, String outFilename)
	        throws InterruptedException, FileNotFoundException, IOException
	    {
	        // load image from filename
	        Image image = Toolkit.getDefaultToolkit().getImage(filename);
	        MediaTracker mediaTracker = new MediaTracker(new Container());
	        mediaTracker.addImage(image, 0);
	        mediaTracker.waitForID(0);
	        // use this to test for errors at this point: System.out.println(mediaTracker.isErrorAny());
	         
	        // determine thumbnail size from WIDTH and HEIGHT
	        double thumbRatio = (double)thumbWidth / (double)thumbHeight;
	        int imageWidth = image.getWidth(null);
	        int imageHeight = image.getHeight(null);
	        double imageRatio = (double)imageWidth / (double)imageHeight;
	        if (thumbRatio < imageRatio) {
	            thumbHeight = (int)(thumbWidth / imageRatio);
	        } else {
	            thumbWidth = (int)(thumbHeight * imageRatio);
	        }
	         
	        // draw original image to thumbnail image object and
	        // scale it to the new size on-the-fly
	        BufferedImage thumbImage = new BufferedImage(thumbWidth, thumbHeight, BufferedImage.TYPE_INT_RGB);
	        Graphics2D graphics2D = thumbImage.createGraphics();
	        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	        graphics2D.drawImage(image, 0, 0, thumbWidth, thumbHeight, null);
	         
	        // save thumbnail image to outFilename
	        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(outFilename));
	        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
	        JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(thumbImage);
	        quality = Math.max(0, Math.min(quality, 100));
	        param.setQuality(quality / 100.0f, false);
	        encoder.setJPEGEncodeParam(param);
	        encoder.encode(thumbImage);
	        out.close();
	        
	        return out;
	    }

}
