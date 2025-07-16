import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;

public class StudentPerformanceAnalytics extends JFrame {

    public StudentPerformanceAnalytics() {
        String studentName = "John Doe";
        String subject = "Mathematics";
        int marks = 85;
        String grade = "A";

        setLayout(new BorderLayout());

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel titleLabel = new JLabel("Student Performance Analytics");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 22));

        JLabel nameLabel = new JLabel("Student Name: " + studentName);
        nameLabel.setFont(new Font("Serif", Font.BOLD, 16));

        JLabel subjectLabel = new JLabel("Subject: " + subject);
        JLabel marksLabel = new JLabel("Marks: " + marks + "/100");
        JLabel gradeLabel = new JLabel("Grade: " + grade);

        headerPanel.add(titleLabel);
        headerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        headerPanel.add(nameLabel);
        headerPanel.add(subjectLabel);
        headerPanel.add(marksLabel);
        headerPanel.add(gradeLabel);

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(85, "Student Performance", "Math");
        dataset.setValue(72, "Student Performance", "Science");
        dataset.setValue(91, "Student Performance", "English");
        dataset.setValue(70, "Student Performance", "History");

        JFreeChart barChart = ChartFactory.createBarChart(
                "",
                "Subject",
                "Marks",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        CategoryPlot plot = barChart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.BLACK);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(800, 400));

        add(headerPanel, BorderLayout.NORTH);
        add(chartPanel, BorderLayout.CENTER);

        setTitle("Student Performance Analytics");
        setSize(850, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentPerformanceAnalytics());
    }
}
