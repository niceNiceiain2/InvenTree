package edu.utsa.cs4593.inventree.controller;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.view.PreviewView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;

import com.google.mlkit.vision.barcode.BarcodeScanner;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;
import com.google.mlkit.vision.barcode.BarcodeScanning;
import com.google.mlkit.vision.barcode.common.Barcode;

import java.util.concurrent.ExecutorService;

import edu.utsa.cs4593.inventree.R;

public class ScanProductIdController extends AppCompatActivity {

    private static final int CAMERA_PERMISSION_REQUEST_CODE = 1001;

    /*
     *  on create will display the scan product id layout
     *  where the user is prompted to grant permission access before
     *  scanning their product id
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scanproductid);

        // Check and request camera permission if not granted
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSION_REQUEST_CODE);

        } else {
            startCameraPreviewOrBarcodeScanner();
        }
    }

    /*
     * Handles the result of the camera permission request.
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == CAMERA_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startCameraPreviewOrBarcodeScanner();
            } else {
                Toast.makeText(this, "Camera permission is required to scan barcodes", Toast.LENGTH_LONG).show();
                finish();
            }
        }
    }

    /*
     * Starts the camera preview or barcode scanner logic.
     * Placeholder for now.
     */
    private void startCameraPreviewOrBarcodeScanner() {
        // TODO: Initialize camera preview or barcode scanning logic here
        Toast.makeText(this, "Camera permission granted. Ready to scan.", Toast.LENGTH_SHORT).show();
    }

}
