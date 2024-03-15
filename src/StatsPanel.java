import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Displays statistics about how many guesses the person took during past games
 * Loads data from the file and displays in a JPanel
 *
 * TODO: refactor this class
 */
public class StatsPanel extends JPanel {

    private final JPanel resultsPanel;

    // Stats will display the number of games in each "bin"
    // A bin goes from BIN_EDGES[i] through BIN_EDGES[i+1]-1, inclusive
    private static final int [] BIN_EDGES = {1, 2, 4, 6, 8, 10, 12, 14};
    private ArrayList<JLabel> resultsLabels;

    public StatsPanel(JPanel cardsPanel) {
        GameStats stats = new StatsFile();
        createLayout();


        /*
        JLabel title = new JLabel("Your Stats");
        this.add(title);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel subtitle = new JLabel("(Past 30 Days)");
        this.add(subtitle);
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

         */

        resultsPanel = new JPanel();
        resultsLabels = new ArrayList<>();

        resultsPanel.setLayout(new GridLayout(0, 2));
        resultsPanel.add(new JLabel("Guesses"));
        resultsPanel.add(new JLabel("Games"));
        for(int binIndex=0; binIndex<BIN_EDGES.length; binIndex++){
            String binName;
            if(binIndex == BIN_EDGES.length-1){
                // last bin
                binName = BIN_EDGES[binIndex] + " or more";
            }
            else{
                int upperBound = BIN_EDGES[binIndex+1] - 1;
                if(upperBound > BIN_EDGES[binIndex]){
                    binName = BIN_EDGES[binIndex] + "-" + upperBound;
                }
                else{
                    binName = Integer.toString(BIN_EDGES[binIndex]);
                }
            }

            resultsPanel.add(new JLabel(binName));
            JLabel result = new JLabel("--");
            resultsLabels.add(result);
            resultsPanel.add(result);
        }

        resultsPanel.setMinimumSize(new Dimension(120, 120));
        this.add(resultsPanel);
        resultsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        updateResultsPanel(stats);

        this.add(Box.createVerticalGlue());

        JButton quit = new JButton("Back to Home");
        quit.addActionListener(e -> {
            // See itemStateChanged in https://docs.oracle.com/javase/tutorial/uiswing/examples/layout/CardLayoutDemoProject/src/layout/CardLayoutDemo.java
            CardLayout cardLayout = (CardLayout) cardsPanel.getLayout();
            cardLayout.show(cardsPanel, ScreenID.HOME.name());
        });
        this.add(quit);
        quit.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(Box.createRigidArea(new Dimension(0,20)));

        this.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent e) {
                updateResultsPanel(stats);
            }
        });
    }

    private void createLayout() {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        addTitleAndSubtitle();
        addSpacing(40); // number wolfe had originally
//        initializeResultsPanel();

    }

    private void addTitleAndSubtitle() {
        addLabel("Your Stats", Component.CENTER_ALIGNMENT);
        addLabel("(Past 30 Days)", Component.CENTER_ALIGNMENT);
    }

    private void addLabel(String text, float alignment) {
        JLabel label = new JLabel(text);
        this.add(label);
        label.setAlignmentX(alignment);
    }

    private void addSpacing(int size) {
        this.add(Box.createRigidArea(new Dimension(0,size)));
    }

    private void initializeResultsPanel() {
        //resultsPanel = createResultsPanel();
    }

    private JPanel createResultsPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 2));
        resultsLabels = new ArrayList<>();

        return panel;
    }

    private void clearResults(){
        for(JLabel lbl : resultsLabels){
            lbl.setText("--");
        }
    }

    private void updateResultsPanel(GameStats stats) {
        clearResults();

        for(int binIndex=0; binIndex<BIN_EDGES.length; binIndex++){
            final int lowerBound = BIN_EDGES[binIndex];
            int numGames = calculateNumGames(stats, binIndex, lowerBound);
            updateResultLabel(binIndex, numGames);
        }
    }

    private int calculateNumGames(GameStats stats, int binIndex, int lowerBound) {
        int numGames = 0;
        if (binIndex == BIN_EDGES.length - 1) {
            for (int numGuesses = lowerBound; numGuesses < stats.maxNumGuesses(); numGuesses++) {
                numGames += stats.numGames(numGuesses);
            }
        }
        else {
            int upperBound = BIN_EDGES[binIndex + 1];
            for (int numGuesses = lowerBound; numGuesses <= upperBound; numGuesses++) {
                numGames += stats.numGames(numGuesses);
            }
        }
        return numGames;
    }

    private void updateResultLabel(int binIndex, int numGames) {
        JLabel resultLabel = resultsLabels.get(binIndex);
        resultLabel.setText(Integer.toString(numGames));
    }
}