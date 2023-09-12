
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;


public class DigitalClock extends JFrame{
	
	private JLabel timeLabel;
	private JLabel dateLabel;
	
	//constructor
	public DigitalClock() {
		setTitle("Digital Clock");
		setSize(500,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		//create a panel to hold time and date labels
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		panel.setLayout(new BorderLayout());
		
		//Create label to display the time
		timeLabel = new JLabel();
		timeLabel.setFont(new Font("Arial",Font.PLAIN,60));
		timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		timeLabel.setVerticalAlignment(SwingConstants.CENTER);
		timeLabel.setForeground(Color.GREEN);
		
		//Create label to display the date
		dateLabel = new JLabel();
		dateLabel.setFont(new Font("Arial",Font.PLAIN,20));
		dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateLabel.setVerticalAlignment(SwingConstants.CENTER);
		dateLabel.setForeground(Color.WHITE);
		
		//Add the time and date label to the panel
		panel.add(dateLabel, BorderLayout.SOUTH);
		panel.add(timeLabel, BorderLayout.CENTER);
		
		//Set panel background color
		panel.setBackground(Color.BLACK);
		
		//Add panel to the frame
		add(panel);
		
		 // Use a Timer to update the time and date labels every second
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTimeAndDate();
            }
        });
        timer.start();
		
		
}
	
	 private void updateTimeAndDate() {
	        // Get the current time and format it
	        Calendar calendar = Calendar.getInstance();
	        SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");
	        String time = timeFormatter.format(calendar.getTime());

	        // Get the current date and format it
	        SimpleDateFormat dateFormatter = new SimpleDateFormat("EEE, MMM dd, yyyy");
	        String date = dateFormatter.format(calendar.getTime());

	        // Update the time and date labels
	        timeLabel.setText(time);
	        dateLabel.setText(date);
	    }


	public static void main(String[] args) {

		DigitalClock clock = new DigitalClock();
		clock.setVisible(true);
	}
	//End of main method
}
//End of class