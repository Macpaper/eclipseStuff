package mainreal;

import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import javax.swing.JFrame;

public class BeatKitchen implements ControllerEventListener {
	
	static JFrame f = new JFrame("My First Java Music Video!@!@!@!@!");
	static MyDrawPanel ml;
	
	
	public static void main(String[] args) {
		BeatKitchen mini = new BeatKitchen();
		mini.play();
	}
	
	public void setUpGui() {
		ml = new MyDrawPanel();
		f.setContentPane(ml);
		f.setBounds(30, 30, 300, 300);
		f.setVisible(true);
		
	}
	
	public void play() {
		setUpGui();
		try {
			Sequencer player = MidiSystem.getSequencer();
			player.open();
			player.addControllerEventListener(ml, new int[] {127});
			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Track track = seq.createTrack();
			
			int r = 0;
			for(int i = 0; i < 360; i+=4) {
				
				r = (int) ((Math.random() * 50) + 1); 
				track.add(makeEvent(144, 1, r, 100, i));
				track.add(makeEvent(176,1,127,0,i));
				track.add(makeEvent(128,1,r,100,i+2));
				
			}
			player.setSequence(seq);
			player.setTempoInBPM(720);
			player.start();
//			ShortMessage a = new ShortMessage();
//			a.setMessage(144,1,39,100);
//			MidiEvent noteOn = new MidiEvent(a,1);
//			track.add(noteOn);
//			
//			ShortMessage b = new ShortMessage();
//			b.setMessage(128, 1,44, 100);
//			MidiEvent noteOff = new MidiEvent(b,16);
//			track.add(noteOff);
			
//			player.setSequence(seq);
//			player.start();
			
		} catch (Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
		MidiEvent event = null;
		try {
			ShortMessage a = new ShortMessage();
			a.setMessage(comd, chan, one, two);
			event = new MidiEvent(a, tick);
		} catch (Exception e) {
			
		}
		return event;
	}
	@Override
	public void controlChange(ShortMessage event) {
		System.out.println("la");
	}

}
