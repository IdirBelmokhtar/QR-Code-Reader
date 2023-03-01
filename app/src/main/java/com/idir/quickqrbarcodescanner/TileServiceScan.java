package com.idir.quickqrbarcodescanner;

import android.content.Intent;
import android.os.Build;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

@RequiresApi(api = Build.VERSION_CODES.N)
public class TileServiceScan extends TileService {

    // I added Tile just to start QR & Barcode Scanner app, you find it in google play and his package is : com.gamma.scan

    @Override
    public void onTileAdded() {
        //Toast.makeText(this, "onTileAdded", Toast.LENGTH_SHORT).show();
        super.onTileAdded();
    }

    @Override
    public void onStartListening() {
        Tile tile = getQsTile();
        tile.setLabel(getString(R.string.qr_scan));
        tile.setState(Tile.STATE_ACTIVE);
        tile.updateTile();
        super.onStartListening();
    }

    @Override
    public void onClick() {

        try {
            Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.gamma.scan");

            launchIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivityAndCollapse(launchIntent);

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplication(), "Your device is not compatible with this App, Inconvenience is regretted :(", Toast.LENGTH_LONG).show();
        }

        getQsTile().updateTile();
        super.onClick();
    }

}
