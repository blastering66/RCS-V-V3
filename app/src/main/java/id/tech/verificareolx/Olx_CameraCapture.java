package id.tech.verificareolx;

/**
 * Created by RebelCreative-A1 on 03/03/2016.
 */
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import id.tech.util.Parameter_Collections;

public class Olx_CameraCapture extends AppCompatActivity implements SurfaceHolder.Callback, Camera.ShutterCallback, Camera.PictureCallback{
    ActionBar ac;
    SurfaceView surfaceView;
    ImageView btn_capture,btn_switch;
    Camera mCamera;
    int id_CameraBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_capture);

        ac = getSupportActionBar();
        ac.hide();
        btn_capture = (ImageView)findViewById(R.id.btn_capture);
        btn_capture.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                onSnapClick(v);
            }
        });
        btn_switch = (ImageView)findViewById(R.id.btn_switch);
        btn_switch.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                mCamera.release();
                mCamera = Camera.open();
            }
        });

        surfaceView = (SurfaceView)findViewById(R.id.surfaceview);
        surfaceView.getHolder().addCallback(this);
        surfaceView.getHolder().setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

        if(isFrontCameraAvailable()){
            int cameraCount = 0;
            Camera cam = null;
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            cameraCount = Camera.getNumberOfCameras();
            for (int camIdx = 0; camIdx<cameraCount; camIdx++) {
                Camera.getCameraInfo(camIdx, cameraInfo);
                if (cameraInfo.facing == Camera.CameraInfo.CAMERA_FACING_FRONT) {
                    try {
                        cam = Camera.open(camIdx);
                    } catch (RuntimeException e) {
                        Log.e("Your_TAG", "Camera failed to open: " + e.getLocalizedMessage());
                    }
                }
            }

            mCamera = cam;

        }else{

            mCamera = Camera.open();
        }


    }

    private boolean isFrontCameraAvailable() {

        int cameraCount = 0;
        boolean isFrontCameraAvailable = false;
        cameraCount = Camera.getNumberOfCameras();

        while (cameraCount > 0) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            cameraCount--;
            Camera.getCameraInfo(cameraCount, cameraInfo);


            if (cameraInfo.facing == Camera.CameraInfo.CAMERA_FACING_FRONT) {
                isFrontCameraAvailable = true;
                break;
            }

        }

        return isFrontCameraAvailable;
    }

    @Override
    public void onPause() {
        super.onPause();
        mCamera.stopPreview();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mCamera.release();
        Log.d("CAMERA", "Destroy");
    }

    public void onCancelClick(View v) {
        finish();
    }

    public void onSnapClick(View v) {
        mCamera.takePicture(this, null, null, this);
    }

    @Override
    public void onPictureTaken(byte[] data, Camera camera) {
//Here, we chose internal storage
        SaveImage(data);
        camera.startPreview();
        finish();
    }

    private String SaveImage(byte[] data_photo_taken) {

        if (Environment.isExternalStorageEmulated()) {
            String root = Environment.getExternalStorageDirectory().toString();
            File myDir = new File(root + Parameter_Collections.URL_FOLDER_IMG_ISSUE);
            myDir.mkdirs();
            Random generator = new Random();
            int n = 10000;
            n = generator.nextInt(n);

            Calendar c = Calendar.getInstance();
            Date date = c.getTime();
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd_HHmmss");

            // String namafile = "temp";
            String namafile = format.format(date);

            String fname =  namafile + ".jpg";
            File file = new File(myDir, fname);
            if (file.exists())
                file.delete();
            try {
                FileOutputStream out = new FileOutputStream(file);
//				finalBitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
                out.write(data_photo_taken);
                out.flush();
                out.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

            return file.getAbsolutePath();
        } else {

            String root = Environment.getExternalStorageDirectory().toString();
            File myDir = new File(root + Parameter_Collections.URL_FOLDER_IMG_ISSUE);
            myDir.mkdirs();
            Random generator = new Random();
            int n = 10000;
            n = generator.nextInt(n);

            Calendar c = Calendar.getInstance();
            Date date = c.getTime();
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd_HHmmss");

            // String namafile = "temp";
            String namafile = format.format(date);

            String fname =  namafile + ".jpg";
            File file = new File(myDir, fname);
            if (file.exists())
                file.delete();
            try {
                FileOutputStream out = new FileOutputStream(file);
//				finalBitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
                out.write(data_photo_taken);
                out.flush();
                out.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

            return file.getAbsolutePath();
        }

    }

    @Override
    public void onShutter() {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        try {
            mCamera.setPreviewDisplay(surfaceView.getHolder());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        Camera.CameraInfo info = new Camera.CameraInfo();
        Camera.getCameraInfo(Camera.CameraInfo.CAMERA_FACING_BACK, info);
        int rotation = this.getWindowManager().getDefaultDisplay().getRotation();
        int degrees = 0;
        switch (rotation) {
            case Surface.ROTATION_0: degrees = 0; break; //Natural orientation
            case Surface.ROTATION_90: degrees = 90; break; //Landscape left
            case Surface.ROTATION_180: degrees = 180; break;//Upside down
            case Surface.ROTATION_270: degrees = 270; break;//Landscape right
        }
        int rotate = (info.orientation - degrees + 360) % 360;

        //STEP #2: Set the 'rotation' parameter
        Camera.Parameters params = mCamera.getParameters();
        params.setRotation(rotate);
        mCamera.setParameters(params);
        mCamera.setDisplayOrientation(90);
        mCamera.startPreview();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        Log.i("PREVIEW","surfaceDestroyed");

    }
}
