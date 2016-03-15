package id.tech.util;

import android.graphics.Bitmap;

/**
 * Created by RebelCreative-A1 on 02/03/2016.
 */
public class RowDataGallery {

    public String title,path;
    public Bitmap bitmap;

    public RowDataGallery(String title, String path, Bitmap bitmap) {
        this.title = title;
        this.path = path;
this.bitmap = bitmap;
    }

    public RowDataGallery( String path, Bitmap bitmap) {
        this.title = title;
        this.path = path;
        this.bitmap = bitmap;
    }
}
