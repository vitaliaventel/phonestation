package finalproject.inface;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Class creates dialog window "about"
 * @author VitaliyL
 *
 */
public class AboutDialog extends JDialog{
	/**
	 * Constructor create new Dialog Window
	 * @param frame Parent frame which start dialog
	 */
	public AboutDialog(JFrame frame) {
		super(frame,"About..", true);
		add(new JTextArea("Copyright � 2016 by Vitaly Leshchenko" + "\n "
				+ "All rights reserved. No part of this publication may be reproduced, distributed, or \n"
				+ "transmitted in any form or by any means, including photocopying, recording, or other \n"
				+ "electronic or mechanical methods, without the prior written permission of the \n"
				+ "publisher, except in the case of brief quotations embodied in critical reviews and \n"
				+ "certain other noncommercial uses permitted by copyright law. For permission requests, \n"
				+ "write to the publisher, addressed �Attention: Permissions Coordinator,� at the address \n"
				+ "below.\n"
				+ "Ukraine, Kyiv, KPI"), BorderLayout.CENTER);

		JButton ok = new JButton("OK");
		ok.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {
				dispose();
			}
		});
		
		JPanel panel = new JPanel();
		panel.add(ok);
		add(panel, BorderLayout.SOUTH);
		setSize(500, 260);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}