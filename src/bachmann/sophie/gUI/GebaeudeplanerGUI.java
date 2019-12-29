package bachmann.sophie.gUI;

import javax.swing.JFrame;
import javax.swing.JCheckBox;

public class GebaeudeplanerGUI {

	// private variables
	private JFrame frmGebaeudeplaner;
	private JCheckBox chckbxFensterUndTuermenge;
	private JCheckBox chckbxBetonUndBewehrungsmenge;
	private JCheckBox chckbxSeitlicheWandflaeche;
	
	// constructor
	public GebaeudeplanerGUI(JFrame frmGebaeudeplaner,
	JCheckBox chckbxFensterUndTuermenge,
	JCheckBox chckbxBetonUndBewehrungsmenge,
	JCheckBox chckbxSeitlicheWandflaeche) {
		this.frmGebaeudeplaner = frmGebaeudeplaner;
		this.chckbxFensterUndTuermenge = chckbxFensterUndTuermenge;
		this.chckbxBetonUndBewehrungsmenge = chckbxBetonUndBewehrungsmenge;
		this.chckbxSeitlicheWandflaeche = chckbxSeitlicheWandflaeche;
	}
}

