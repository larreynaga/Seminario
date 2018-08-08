package com.example.mauricio.musicplayer;


        import android.media.MediaPlayer;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.Toast;
        import android.view.View;


public class MainActivity extends AppCompatActivity {
   MediaPlayer mp;
   int pause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void play(View view){
        if(mp == null) {
            mp = MediaPlayer.create(this, R.raw.musica);
            mp.start();
            Toast.makeText(this, "Play", Toast.LENGTH_SHORT).show();
        }else{
            if(!mp.isPlaying()){
                mp.seekTo(pause);
                mp.start();
                Toast.makeText(this, "Play", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void pause(View view){
        if(mp !=null) {
            mp.pause();
            pause = mp.getCurrentPosition();
            Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();
        }
    }
    public void stop(View view){
        mp.stop();
        mp=null;
        Toast.makeText(this,"Stop", Toast.LENGTH_SHORT).show();
    }
}
