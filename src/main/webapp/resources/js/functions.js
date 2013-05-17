/**
 * @author Patrick Cieni
 */
var num = 0;
var len = 4;

function toggle(toggle_div){

    var frame_ = document.getElementById(toggle_div);
    
    if (frame_.style.display == 'block') {
    
    
        frame_.style.display = 'none'
        
    }
    else {
    
        frame_.style.display = 'block'
        
    }
    
}

function minimizeMaximizeToggle(hide_div, clickButton){

    var frame_ = document.getElementById(hide_div);
    var button_ = document.getElementById(clickButton);
    
    //Change Click Button
    if (button_.className == "Maximize") {
        button_.className = "Minimize";
    }
    else 
        if (button_.className == "Minimize") {
            button_.className = "Maximize";
        }
    
    
    if (frame_.style.height == "450px") {
        var frame_ = document.getElementById(hide_div);
        frame_.style.height = "40px";
        
    }
    else 
        if (frame_.style.height == "40px") {
            var frame_ = document.getElementById(hide_div);
            frame_.style.height = "450px";
            
        }
    
    
    
    
}


function minimizeMaximizeToggle_(hide_div, clickButton){

    var frame_ = document.getElementById(hide_div);
    var button_ = document.getElementById(clickButton);
    
    //Change Click Button
    if (button_.className == "Maximize") {
        button_.className = "Minimize";
    }
    else 
        if (button_.className == "Minimize") {
            button_.className = "Maximize";
        }
    
    
    
    if (frame_.style.height == "169px") {
        var frame_ = document.getElementById(hide_div);
        frame_.style.height = "40px";
        
    }
    else 
        if (frame_.style.height == "40px") {
            var frame_ = document.getElementById(hide_div);
            frame_.style.height = "169px";
            
        }
    
}

function minimizeMaximizeToggle_General(hide_div, clickButton,min,max){

    var frame_ = document.getElementById(hide_div);
    var button_ = document.getElementById(clickButton);
    
    //Change Click Button
    if (button_.className == "Maximize") {
        button_.className = "Minimize";
    }
    else 
        if (button_.className == "Minimize") {
            button_.className = "Maximize";
        }
    
    
    
    if (frame_.style.right == max) {
        var frame_ = document.getElementById(hide_div);
        frame_.style.right = min;
        
    }
    else 
        if (frame_.style.right == min) {
            var frame_ = document.getElementById(hide_div);
            frame_.style.right = max;
            
        }
    
}

function minimizeMaximizeToggle_Chat(hide_div, clickButton,min,max){

    var frame_ = document.getElementById(hide_div);
    var button_ = document.getElementById(clickButton);
    
    //Change Click Button
    if (button_.className == "Maximize-Chat") {
        button_.className = "Minimize-Chat";
    }
    else 
        if (button_.className == "Minimize-Chat") {
            button_.className = "Maximize-Chat";
        }
    
    
    
    if (frame_.style.bottom == max) {
        var frame_ = document.getElementById(hide_div);
        frame_.style.bottom = min;
        
    }
    else 
        if (frame_.style.bottom == min) {
            var frame_ = document.getElementById(hide_div);
            frame_.style.bottom = max;
            
        }
    
}


function minimizeMaximizeToggleImage(hide_div, clickButton){

    var frame_ = document.getElementById(hide_div);
    var button_ = document.getElementById(clickButton);
    
    //Change Click Button
    if (button_.className == "Maximize") {
        button_.className = "Minimize";
    }
    else 
        if (button_.className == "Minimize") {
            button_.className = "Maximize";
        }
    
    
    //Maximize or compress Image Div
    if (frame_.style.height == "530px") {
        var frame_ = document.getElementById(hide_div);
        frame_.style.height = "30px";
        
        minimizeMaximizeToggle('LatestLayers', 'LatestLayers_MaxMin');
        minimizeMaximizeToggle_('LatestMaps', 'LatestMaps_MaxMin');
        
    }
    else 
        if (frame_.style.height == "30px") {
            var frame_ = document.getElementById(hide_div);
            frame_.style.height = "530px";
            
            minimizeMaximizeToggle('LatestLayers', 'LatestLayers_MaxMin');
            minimizeMaximizeToggle_('LatestMaps', 'LatestMaps_MaxMin');
            
            
        }
    
    
}

//Design 1 javascript
function nextImage(imageNo){

    //alert("image_" + imageNo);
    if (imageNo == len) {
        //Initialize Slider Start
        num = 0;
    }
    
	num++
	if(imageNo != 0){
		
		var k = document.getElementById("image_" + imageNo);
        k.style.opacity = 0;
		
	}  
    
    //increament Page
    imageNo = num;
    
    var k = document.getElementById("image_" + imageNo);
    k.style.opacity = 1;
    
    //alert the slider & counter
    nextSlider(imageNo);
    
    //var counter_ = document.getElementById("counter");
    //counter_.innerHTML = pageNo + " out of " + len;
    
}

function nextSlider(counter){

    //increament Page
    var temp = 0;
	temp = counter
    temp--;
    
	//alert("image_slider_" + temp);
	
	if(temp >0){
		var k = document.getElementById("image_slider_" + temp);
        k.style.left = "990px";
	}else{
		
		var k = document.getElementById("image_slider_" + len);
        k.style.left = "990px";
		
	}
      
    var k = document.getElementById("image_slider_" + counter);
    k.style.left = "5px";
    
}


function changeImg(){

    /*var cur_page_ = document.getElementById('cur_page');
     var max_page_ = document.getElementById('max_page');
     var next_topic_ = document.getElementById('next_topic');
     var title_ = document.getElementById('header_title');
     var story_ = document.getElementById('story');
     var imageDir = 'images/'; // change to match images folder
     */
    var delayInSeconds = 5; // set number of seconds delay
    // list image names
    
    var num = 0;
    var changeImage = function(){
    
        //alert(story_main_[num]);
        // var y = imageDir + images[num];
        //rotator.src = y;
        
        nextImage(num);
        if (num == 4) {
            num = 0;
        }
        num++

        // next_topic_.innerHTML = link_[num];
    };
    
    setInterval(changeImage, delayInSeconds * 1000);
    
}


