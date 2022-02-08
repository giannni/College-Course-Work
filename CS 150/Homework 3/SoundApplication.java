import javax.swing.*;

public class SoundApplication
{
    public static void main()
    {
     String inputNameString,fileNameString,inputComposerString,inputRatingString;
     
     /*
     inputNameString = JOptionPane.showInputDialog("Enter a the name of the song");
     inputComposerString = JOptionPane.showInputDialog("Enter a the name of the composer");
     fileNameString = inputNameString + ".wav";
     Song mySong = new Song(fileNameString, inputNameString, inputComposerString);
     System.out.println(mySong);
     mySong.play();
     */
     
     inputNameString = JOptionPane.showInputDialog("Enter a the name of the song");
     inputComposerString = JOptionPane.showInputDialog("Enter a the name of the composer");
     fileNameString = inputNameString + ".wav";
     SongHistory mySongRecord = new SongHistory (fileNameString, inputNameString, inputComposerString, 2013);
     System.out.println(mySongRecord);
     mySongRecord.play();
     
     
     /*
     inputNameString = JOptionPane.showInputDialog("Enter a the name of the sound effect");
     inputRatingString = JOptionPane.showInputDialog("Enter a rating for this sound effect");
     fileNameString = inputNameString + ".wav";
     SoundEffect myEffect = new SoundEffect(fileNameString, inputNameString, Integer.parseInt(inputRatingString));
     System.out.println(myEffect);
     myEffect.play();
     */

    }
}