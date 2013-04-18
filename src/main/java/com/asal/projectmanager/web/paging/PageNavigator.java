package com.asal.projectmanager.web.paging;

public interface PageNavigator {
    String buildPageNav(String path, int resultSize, int page, int pageSize, int pageNavTrail);
}
