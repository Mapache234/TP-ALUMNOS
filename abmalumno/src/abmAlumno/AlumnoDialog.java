/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abmAlumno;

import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import miCalendar.MiCalendar;
import persona.Alumno;
import persona.PersonaInvalidaException;

/**
 *
 * @author nestor
 */
public class AlumnoDialog extends javax.swing.JDialog
{

	/**
	 * Creates new form AlumnoDialog
	 */
	public AlumnoDialog(java.awt.Frame parent, boolean modal)
	{
		super(parent, modal);
		initComponents();
	}
	
	
	
	Alumno mostrarDialogoCrear()
	{
		borrarCampos();
		
		estadoComboBox.setSelectedItem("A");
		
		setVisible(true);
		
		if(guardar)
			try 
			{
				return formularioAAlumno(null);
			}
			catch(PersonaInvalidaException ex)
			{
				Logger.getLogger(AlumnoDialog.class.getName()).log(Level.SEVERE, null, ex);
				return null;
			}
		
		return null;
	}
	
	
	boolean mostraDialogoEditar(Alumno alu)
	{
		alumnoAFormulario(alu);
		
		setVisible(true);
		
		if(guardar)
		{
			try
			{
				formularioAAlumno(alu);
			}
			catch(PersonaInvalidaException ex)
			{
				Logger.getLogger(AlumnoDialog.class.getName()).log(Level.SEVERE, null, ex);
				return false;
			}
			
			return true;
		}
		
		return false;
	}
	
	
	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        dniFormattedTextField = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        apynTextField = new javax.swing.JTextField();
        fechaNacDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        sexoComboBox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        fechaIngrDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        cantMatAprobFormattedTextField = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        carreraComboBox = new javax.swing.JComboBox<>();
        promedioFormattedTextField = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        estadoComboBox = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        guardarButton = new javax.swing.JButton();
        cancelarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("DNI");

        dniFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        jLabel2.setText("Apyn");

        jLabel3.setText("Fecha Nac.");

        sexoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F" }));

        jLabel4.setText("Sexo");

        jLabel5.setText("Fecha Ingr.");

        cantMatAprobFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        jLabel6.setText("Cant. Mat. Aprob.");

        jLabel7.setText("Carrera");

        carreraComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "INF", "ELE", "MED", "ABO" }));

        promedioFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));

        jLabel8.setText("Promedio");

        estadoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B" }));
        estadoComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estadoComboBoxActionPerformed(evt);
            }
        });

        jLabel9.setText("Estado");

        guardarButton.setText("Guardar");
        guardarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarButtonActionPerformed(evt);
            }
        });

        cancelarButton.setText("Cancelar");
        cancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(dniFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(apynTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fechaNacDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(sexoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fechaIngrDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(cantMatAprobFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(carreraComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(promedioFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(estadoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(guardarButton)
                .addGap(4, 4, 4)
                .addComponent(cancelarButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dniFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(apynTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(fechaNacDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sexoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fechaIngrDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cantMatAprobFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(carreraComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(promedioFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(estadoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardarButton)
                    .addComponent(cancelarButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_guardarButtonActionPerformed
    {//GEN-HEADEREND:event_guardarButtonActionPerformed
		guardar = true;
		
		setVisible(false);
    }//GEN-LAST:event_guardarButtonActionPerformed
	
	
    private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cancelarButtonActionPerformed
    {//GEN-HEADEREND:event_cancelarButtonActionPerformed
        guardar = false;
		
		setVisible(false);
    }//GEN-LAST:event_cancelarButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowClosing
    {//GEN-HEADEREND:event_formWindowClosing
        guardar = false;
    }//GEN-LAST:event_formWindowClosing

    private void estadoComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadoComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_estadoComboBoxActionPerformed

	private Alumno formularioAAlumno(Alumno alu) throws PersonaInvalidaException
	{
		if(alu == null)
			alu = new Alumno();
		
		try
		{
			dniFormattedTextField.commitEdit();
			cantMatAprobFormattedTextField.commitEdit();
			promedioFormattedTextField.commitEdit();
		}
		catch(ParseException ex)
		{
			Logger.getLogger(AlumnoDialog.class.getName()).log(Level.SEVERE, null, ex);
			setVisible(false);
			return null;
		}
		
		alu.setDni(((Number)(dniFormattedTextField.getValue())).intValue());
		alu.setApyn(apynTextField.getText());
		alu.setFechaNac(new MiCalendar(fechaNacDateChooser.getCalendar()));
		alu.setSexo(((String)(sexoComboBox.getSelectedItem())).charAt(0));
		alu.setFechaIngreso(new MiCalendar(fechaIngrDateChooser.getCalendar()));
		alu.setCantMatAprob(((Number)(cantMatAprobFormattedTextField.getValue())).intValue());
		alu.setPromedio(((Number)(promedioFormattedTextField.getValue())).doubleValue());
                alu.setCarrera((String)carreraComboBox.getSelectedItem());
		alu.setEstado(((String)(estadoComboBox.getSelectedItem())).charAt(0));
		
		return alu;
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[])
	{
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try
		{
			for(javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
			{
				if("Nimbus".equals(info.getName()))
				{
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		}
		catch(ClassNotFoundException ex)
		{
			java.util.logging.Logger.getLogger(AlumnoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		catch(InstantiationException ex)
		{
			java.util.logging.Logger.getLogger(AlumnoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		catch(IllegalAccessException ex)
		{
			java.util.logging.Logger.getLogger(AlumnoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		catch(javax.swing.UnsupportedLookAndFeelException ex)
		{
			java.util.logging.Logger.getLogger(AlumnoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the dialog */
		java.awt.EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				AlumnoDialog dialog = new AlumnoDialog(new javax.swing.JFrame(), true);
				dialog.addWindowListener(new java.awt.event.WindowAdapter()
				{
					@Override
					public void windowClosing(java.awt.event.WindowEvent e)
					{
						System.exit(0);
					}
				});
				dialog.setVisible(true);
			}
		});
	}
	
	
	private boolean guardar;
	
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apynTextField;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JFormattedTextField cantMatAprobFormattedTextField;
    private javax.swing.JComboBox<String> carreraComboBox;
    private javax.swing.JFormattedTextField dniFormattedTextField;
    private javax.swing.JComboBox<String> estadoComboBox;
    private com.toedter.calendar.JDateChooser fechaIngrDateChooser;
    private com.toedter.calendar.JDateChooser fechaNacDateChooser;
    private javax.swing.JButton guardarButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JFormattedTextField promedioFormattedTextField;
    private javax.swing.JComboBox<String> sexoComboBox;
    // End of variables declaration//GEN-END:variables

	private void borrarCampos()
	{
                dniFormattedTextField.setValue(null);
                apynTextField.setText("");
                dniFormattedTextField.setValue(null);
                cantMatAprobFormattedTextField.setValue(null);
                promedioFormattedTextField.setValue(null);
                fechaIngrDateChooser.setCalendar(null);
                fechaNacDateChooser.setCalendar(null);
	//	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	private void alumnoAFormulario(Alumno alu)
	{
		dniFormattedTextField.setValue(alu.getDni());
		apynTextField.setText(alu.getApyn());
		fechaNacDateChooser.setCalendar(alu.getFechaNac());
		sexoComboBox.setSelectedItem(String.valueOf(alu.getSexo()));
		fechaIngrDateChooser.setCalendar(alu.getFechaIngreso());
		cantMatAprobFormattedTextField.setValue(alu.getCantMatAprob());
		carreraComboBox.setSelectedItem(alu.getCarrera());
		promedioFormattedTextField.setValue(alu.getPromedio());
		estadoComboBox.setSelectedItem(String.valueOf(alu.getEstado()));
	}
}
