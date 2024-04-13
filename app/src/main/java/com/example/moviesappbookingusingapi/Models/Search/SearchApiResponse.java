package com.example.moviesappbookingusingapi.Models.Search;

import java.util.List;

public class SearchApiResponse {
    List<SearchArrayObject> data= null;
    List<SearchArrayObject> metadata= null;

    public SearchApiResponse(List<SearchArrayObject> data, List<SearchArrayObject> metadata) {
        this.data = data;
        this.metadata = metadata;
    }

    public List<SearchArrayObject> getData() {
        return data;
    }

    public List<SearchArrayObject> getMetadata() {
        return metadata;
    }

    public void setData(List<SearchArrayObject> data) {
        this.data = data;
    }

    public void setMetadata(List<SearchArrayObject> metadata) {
        this.metadata = metadata;
    }
}
