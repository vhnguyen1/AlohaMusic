package edu.orangecoastcollege.cs273.vnguyen629.alohamusic;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 *
 */
public class MediaActivity extends AppCompatActivity {

    private MediaPlayer ukuleleMP;
    private MediaPlayer ipuMP;
    //private MediaPlayer hulaMP;

    private Button ukuleleButton;
    private Button ipuButton;
    private Button hulaButton;
    private VideoView hulaVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        ukuleleButton = (Button) findViewById(R.id.ukuleleButton);
        ipuButton = (Button) findViewById(R.id.ipuButton);
        hulaButton = (Button) findViewById(R.id.hulaButton);
        hulaVideo = (VideoView) findViewById(R.id.hulaVideoView);

        // Associate the MediaPlayer objects with the raw audio files
        ukuleleMP = MediaPlayer.create(this, R.raw.ukulele);
        ipuMP = MediaPlayer.create(this, R.raw.ipu);

        // Associate the media player object with the hula video
        hulaVideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.hula));
        hulaVideo.setMediaController(new MediaController(this));
    }

    public void playMedia(View view) {
        // Determine which of the three buttons is clicked
        switch (view.getId()) {
            case R.id.ukuleleButton:
                if (ukuleleMP.isPlaying()) {

                    ukuleleButton.setText(R.string.ukulele_button_play_text);
                    ukuleleMP.pause();

                    // show other two buttons (ipu and hula)
                    ipuButton.setVisibility(View.VISIBLE);
                    hulaButton.setVisibility(View.VISIBLE);
                }
                else {

                    ukuleleButton.setText(R.string.ukulele_button_pause_text);
                    ukuleleMP.start();

                    // hide other two buttons (ipu and hula)
                    ipuButton.setVisibility(View.INVISIBLE);
                    hulaButton.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.ipuButton:
                if (ipuMP.isPlaying()) {

                    ipuButton.setText(R.string.ipu_button_play_text);
                    ipuMP.pause();

                    // show other two buttons (ukulele and hula)
                    ukuleleButton.setVisibility(View.VISIBLE);
                    hulaButton.setVisibility(View.VISIBLE);
                }
                else {

                    ipuButton.setText(R.string.ipu_button_pause_text);
                    ipuMP.start();

                    // hide other two buttons (ukulele and hula)
                    ukuleleButton.setVisibility(View.INVISIBLE);
                    hulaButton.setVisibility(View.INVISIBLE);
                }
                break;
            //case R.id.hulaButton:
            default:
                if (hulaVideo.isPlaying()) {

                    //hulaButton.setText(R.string.hula_button_pause_text);
                    hulaButton.setText(R.string.hula_button_watch_text);
                    hulaVideo.pause();

                    // show other two buttons (ukulele and ipu)
                    ukuleleButton.setVisibility(View.VISIBLE);
                    ipuButton.setVisibility(View.VISIBLE);
                }
                else {

                    //hulaButton.setText(R.string.hula_button_watch_text);
                    hulaButton.setText(R.string.hula_button_pause_text);
                    hulaVideo.start();

                    // hide other two buttons (ukulele and ipu)
                    ukuleleButton.setVisibility(View.INVISIBLE);
                    ipuButton.setVisibility(View.INVISIBLE);
                }
        }
    }
}
