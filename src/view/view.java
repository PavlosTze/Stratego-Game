package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import controller.controller;
import model.Pieces.Bomb;
import model.Pieces.Dragon;
import model.Pieces.Dwarf;
import model.Pieces.Flag;
import model.Pieces.Slayer;
import model.Player.Player.COLOR;
import javax.swing.JOptionPane;

/**
* View is the class that will create and do some operations about the interface
* @version 1.0
* @author Pavlos Tzegiannakis - csd3470
*/

@SuppressWarnings("serial")
public class view extends JFrame {

    private JButton PlayButton,exitButton;
    private JPanel panel1,panel2;
    private PieceButton[] buttons = new PieceButton[80];
    private controller game;
    private PieceButton selected;
    private JLabel infoInGame;
    private String[] pieces;
    private String choice;
    private boolean canRestoreRed;
    private boolean canRestoreBlue;
    private int restoredPos;

    /**
    * <b>Constructor</b>: Creates a new Window with the board and initializes some buttons and panels
    * <b>Postcondition</b>: Creates a new Window-Board and initializes some buttons and panels 
    */
    public view() {
        infoInGame = new JLabel("");
        game = new controller();
        this.setBounds(600, 300, 200, 200);
        PlayButton = new JButton();
        PlayButton.setPreferredSize(new Dimension(325,58));
        PlayButton.setBackground(Color.GREEN);
        PlayButton.setFont(new java.awt.Font("EXIT", Font.ITALIC, 50));
        PlayButton.setText("PLAY");
        PlayButton.addActionListener(new ButtonListener());

        exitButton = new JButton();
        exitButton.setPreferredSize(new Dimension(325,58));
        exitButton.setBackground(Color.RED);
        exitButton.setFont(new java.awt.Font("EXIT", Font.ITALIC, 50));
        exitButton.setText("EXIT");
        exitButton.addActionListener(new ButtonListener());

        panel1 = new JPanel();
        panel2 = new JPanel();
        panel1.setLayout(new GridLayout(8,10));
        panel1.setPreferredSize(new Dimension(10,550));
        panel2.setLayout(new GridLayout(0,2));
        panel2.setPreferredSize(new Dimension(10,58));

        getContentPane().add(panel1,BorderLayout.SOUTH);
        getContentPane().add(panel2,BorderLayout.NORTH);
        panel2.add(PlayButton);
        panel2.add(exitButton);
        this.setSize(650, 650);
        this.setTitle("STRATEGO: Fire VS Ice by csd3470");
        this.setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    /**
    * <b>Transformer(mutative)</b>:initializes some buttons and labels after play button pushed
    * <b>Postcondition:</b> initializes some buttons and labels after play button pushed
    */
    private void initComponents() {    		
        for (int i = 0; i < 80; i++)
        {
            if(i==32 || i==33 || i==36 || i==37 || i==42 || i==43 || i==46 || i==47)
            {
                buttons[i] = new PieceButton(Integer.toString(i));
                buttons[i].setBGColor(Color.yellow);
            } else
            {
                buttons[i] = new PieceButton(Integer.toString(i));
                buttons[i].setBGColor(Color.white);
            }
            
            panel1.add(buttons[i].getButton());
            buttons[i].getButton().addActionListener(new ButtonListener());
            
            if(i>49)
            {
                buttons[i].setRedHidden();
                buttons[i].setFirstRedVisible(i);
            } else if(i<30)
            {
                buttons[i].setBlueHidden();
                buttons[i].setFirstBlueVisible(i);
            }
        }
    }

    /**
    * <b>Transformer(mutative)</b>:deletes the Play button after game started and creates the "view" of our game
    * <p><b>Postcondition:</b> Play button deleted  and creates the "view" of our game</p>
    *
    */
    public void actionsAfterPlayPushed() {
        panel2.remove(PlayButton);
        panel2.add(infoInGame);
        infoInGame.setFont(new java.awt.Font("Infos from the battle will be displayed here", Font.CENTER_BASELINE, 15));
        infoInGame.setText("Infos from the battle will be displayed here");
        this.initComponents();
    }

    /** a class which is used for doing some action 
    * after a Piece or Exit or Play button of the board has been pushed 
    */ 
    private class ButtonListener implements ActionListener {

        /**
        * <b>transformer(mutative)</b>:doing some action after an Exit or Play or a simple Board button has been
        * pushed
        * <p>
        * <b>Postcondition:</b> doing some action after an Exit or Play or a simple Board button has been
        * pushed
        * </p>
        */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == exitButton) {
                System.exit(0);
            } else if (e.getSource() == PlayButton) {
                actionsAfterPlayPushed();
                updateView();
            } else {
                JButton but = ((JButton) e.getSource());
                
                game.setPiecePlayed(false);
                updateView();
                setButtonsBorders(but);
                movePiece(selected, but);

                if (game.hasPiecePlayed() == true && !game.game_has_finished()) {
                    if (game.getTurn() == COLOR.BLUE){
                        game.setTurn(COLOR.RED);
                    } else {
                        game.setTurn(COLOR.BLUE);
                    }
                } else if(game.game_has_finished()) {
                    if (game.getTurn() == COLOR.BLUE) {
                        JOptionPane.showMessageDialog(null, "WINNER IS BLUE", "WINNER ANNOUNCEMENT", 1);
                        updateView();
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "WINNER IS RED", "WINNER ANNOUNCEMENT", 1);
                        updateView();
                    }
                }
                selected = new PieceButton("");
                selected.setButton(but);
                if (but.getIcon() != null) {
                    if ("hidBlue".equals(but.getIcon().toString())
                        || (but.getIcon().toString().contains("B") && !("lavaBeast".equals(but.getIcon().toString())))
                        || "yeti".equals(but.getIcon().toString())) {
                        selected.setVis(COLOR.BLUE,but.getIcon());
                    } else if ("hidRed".equals(but.getIcon().toString())
                                || (but.getIcon().toString().contains("R") && !("beastRiderB".equals(but.getIcon().toString())))
                                || "lavaBeast".equals(but.getIcon().toString())
                                || "scoutR".equals(but.getIcon().toString())) {
                        selected.setVis(COLOR.RED,but.getIcon());
                    }
                }
                updateView();
            }
        }
    }


    /**
    * <b>Transformer(mutative)</b>:updates the view whether the game has finished or not. Also updates 
    * the view if a player's piece has reached the enemy's first line and a rescue can take place so it 
    * shows a new window asking for the player's input about what piece he wants to rescue
    * <p><b>Postcondition:</b> updates the view whether the game has finished or not. Also updates 
    * the view if a player's piece has reached the enemy's first line and a rescue can take place so it 
    * shows a new window asking for the player's input about what piece he wants to rescue</p>
    *
    */
    public void updateView() {
        if (!game.game_has_finished()) {
            for (int i = 0; i < 80; i++) {
                if (game.getTurn() == COLOR.RED) {
                    canRestoreRed = true;
                    if (buttons[i].hasIcon() && buttons[i].getHid() != buttons[i].getHidRed()) {
                            buttons[i].setBlueHidden();
                    } else if (buttons[i].hasIcon() && buttons[i].getHid() == buttons[i].getHidRed()) {
                            buttons[i].setVis(COLOR.RED, buttons[i].getVis());
                    }
                } else {
                    canRestoreBlue = true;
                    if (buttons[i].hasIcon() && buttons[i].getHid() != buttons[i].getHidBlue()) {
                            buttons[i].setRedHidden();
                    } else if (buttons[i].hasIcon() && buttons[i].getHid() == buttons[i].getHidBlue()) {
                            buttons[i].setVis(COLOR.BLUE, buttons[i].getVis());
                    }
                }
            }
        } else {
                for (int i = 0; i < 80; i++) {
                    if (buttons[i].hasIcon() && buttons[i].getHid() == buttons[i].getHidRed()) {
                        buttons[i].setVis(COLOR.RED, buttons[i].getVis());
                    } else if (buttons[i].hasIcon() && buttons[i].getHid() == buttons[i].getHidBlue()) {
                        buttons[i].setVis(COLOR.BLUE, buttons[i].getVis());
                    }
                }
        }

        choice = "default";
        restoredPos = -1;

        if(canRestoreRed)
        {
            for (int i = 0; i < 10; i++) {
                if (game.getTurn() == COLOR.BLUE) {
                    if (buttons[i].hasIcon() && buttons[i].getHid() == buttons[i].getHidRed()) {
                        if(game.getBoard().getPiece(i).getRank() != 2 && game.getPlayer(COLOR.RED).getRestored() < 2)
                        {
                            pieces = new String[game.getPlayer(COLOR.RED).getLostPieces().getPieces().size()];
                            for (int k = 0; k < game.getPlayer(COLOR.RED).getLostPieces().getPieces().size(); k++) {
                                if (!("Bomb".equals(game.getPlayer(COLOR.RED).getLostPieces().getPiece(k).getClass().getSimpleName()))
                                    && !("Flag".equals(game.getPlayer(COLOR.RED).getLostPieces().getPiece(k).getClass().getSimpleName()))) {
                                    
                                    pieces[k] = game.getPlayer(COLOR.RED).getLostPieces().getPiece(k).getClass().getSimpleName();
                                }
                            }
                            if(!game.hasRestored(i))
                            {
                                canRestoreRed = false;
                                choice = (String) JOptionPane.showInputDialog(this, "Select Piece\n", "Select Piece",
                                JOptionPane.PLAIN_MESSAGE, null, pieces, "");
                                restoredPos = game.restorePiece(COLOR.RED, choice,i);
                            }
                        }
                        else if(game.getPlayer(COLOR.RED).getRestored() > 2)
                        {
                            break;
                        }
                    } 
                }
            }
        }

        if(canRestoreBlue)
        {
            for (int i = 69; i < 80; i++) {
                if(game.getTurn() == COLOR.RED)
                {
                    if (buttons[i].hasIcon() && buttons[i].getHid() == buttons[i].getHidBlue()) {
                        if(game.getBoard().getPiece(i).getRank() != 2 && game.getPlayer(COLOR.BLUE).getRestored() < 2)
                        {
                            pieces = new String[game.getPlayer(COLOR.BLUE).getLostPieces().getPieces().size()];
                            for (int k = 0; k < game.getPlayer(COLOR.BLUE).getLostPieces().getPieces().size(); k++) {
                                if (!("Bomb".equals(game.getPlayer(COLOR.BLUE).getLostPieces().getPiece(k).getClass().getSimpleName()))
                                    && !("Flag".equals(game.getPlayer(COLOR.BLUE).getLostPieces().getPiece(k).getClass().getSimpleName()))) {
                                    
                                    pieces[k] = game.getPlayer(COLOR.BLUE).getLostPieces().getPiece(k).getClass().getSimpleName();
                                }
                            }
                            if(!game.hasRestored(i))
                            {
                                canRestoreBlue = false;
                                choice = (String) JOptionPane.showInputDialog(this, "Select Piece\n", "Select Piece",
                                JOptionPane.PLAIN_MESSAGE, null, pieces, "");
                                restoredPos = game.restorePiece(COLOR.BLUE, choice,i);
                            }
                        } else if(game.getPlayer(COLOR.BLUE).getRestored() > 2)
                        {
                            break;
                        }
                    }
                }
            }
        }

        if(restoredPos >= 0)
        {
            setViewAfterRestore(restoredPos,choice);
        }
    }

    /**
    * <b>Transformer(mutative)</b>:changes the view after a restore of a piece has happened,
    * adds the restored piece information at the view (icons) and updates text field
    * <b>Postcondition:</b> changes the view after a restore of a piece has happened,
    * adds the restored piece information at the view (icons) and updates text field
    */
    public void setViewAfterRestore(int restoredPos, String choice)
    {
        switch (choice) {
        case "BeastRider":
            if(game.getTurn() == COLOR.BLUE){
                buttons[restoredPos].setVis(COLOR.RED, buttons[restoredPos].beastRiderR);
                buttons[restoredPos].setRedHidden();
            } else{
                buttons[restoredPos].setVis(COLOR.BLUE, buttons[restoredPos].beastRiderB);
                buttons[restoredPos].setBlueHidden();
            }
            break;
        case "Dragon":
            if(game.getTurn() == COLOR.BLUE){
                buttons[restoredPos].setVis(COLOR.RED, buttons[restoredPos].dragonR);
                buttons[restoredPos].setRedHidden();
            } else{
                buttons[restoredPos].setVis(COLOR.BLUE, buttons[restoredPos].dragonB);
                buttons[restoredPos].setBlueHidden();
            }
            break;
        case "Dwarf":
            if(game.getTurn() == COLOR.BLUE){
                    buttons[restoredPos].setVis(COLOR.RED, buttons[restoredPos].dwarfR);
                    buttons[restoredPos].setRedHidden();
            } else{
                    buttons[restoredPos].setVis(COLOR.BLUE, buttons[restoredPos].dwarfB);
                    buttons[restoredPos].setBlueHidden();
            }
            break;
        case "Elf":
            if(game.getTurn() == COLOR.BLUE) {
                    buttons[restoredPos].setVis(COLOR.RED, buttons[restoredPos].elfR);
                    buttons[restoredPos].setRedHidden();
            } else {
                    buttons[restoredPos].setVis(COLOR.BLUE, buttons[restoredPos].elfB);
                    buttons[restoredPos].setBlueHidden();
            }
            break;
        case "Knight":
            if(game.getTurn() == COLOR.BLUE) {
                    buttons[restoredPos].setVis(COLOR.RED, buttons[restoredPos].knightR);
                    buttons[restoredPos].setRedHidden();
            } else {
                    buttons[restoredPos].setVis(COLOR.BLUE, buttons[restoredPos].knightB);
                    buttons[restoredPos].setBlueHidden();
            }
            break;
        case "LavaBeast":
            if(game.getTurn() == COLOR.BLUE) {
                    buttons[restoredPos].setVis(COLOR.RED, buttons[restoredPos].lavaBeast);
                    buttons[restoredPos].setRedHidden();
            }
            break;
        case "Mage":
            if(game.getTurn() == COLOR.BLUE) {
                    buttons[restoredPos].setVis(COLOR.RED, buttons[restoredPos].mageR);
                    buttons[restoredPos].setRedHidden();
            } else {
                    buttons[restoredPos].setVis(COLOR.BLUE, buttons[restoredPos].mageB);
                    buttons[restoredPos].setBlueHidden();
            }
            break;
        case "Scout":
            if(game.getTurn() == COLOR.BLUE) {
                    buttons[restoredPos].setVis(COLOR.RED, buttons[restoredPos].scoutR);
                    buttons[restoredPos].setRedHidden();
            } else {
                    buttons[restoredPos].setVis(COLOR.BLUE, buttons[restoredPos].scoutB);
                    buttons[restoredPos].setBlueHidden();
            }
            break;
        case "Slayer":
            if(game.getTurn() == COLOR.BLUE) {
                    buttons[restoredPos].setVis(COLOR.RED, buttons[restoredPos].slayerR);
                    buttons[restoredPos].setRedHidden();
            } else {
                    buttons[restoredPos].setVis(COLOR.BLUE, buttons[restoredPos].slayerB);
                    buttons[restoredPos].setBlueHidden();
            }
            break;
        case "Sorceress":
            if(game.getTurn() == COLOR.BLUE) {
                    buttons[restoredPos].setVis(COLOR.RED, buttons[restoredPos].sorceressR);
                    buttons[restoredPos].setRedHidden();
            } else {
                    buttons[restoredPos].setVis(COLOR.BLUE, buttons[restoredPos].sorceressB);
                    buttons[restoredPos].setBlueHidden();
            }
            break;
        case "Yeti":
            if(game.getTurn() == COLOR.RED) {
                    buttons[restoredPos].setVis(COLOR.BLUE, buttons[restoredPos].yeti);
                    buttons[restoredPos].setBlueHidden();
            }
            break;
        }
        if(game.getTurn() == COLOR.RED){
            textFieldIngame(10,0,restoredPos,"BLUE",choice);
        } else {
            textFieldIngame(10,0,restoredPos,"RED",choice);
        }
    }

    /**
    * <b>Transformer(mutative)</b>: based on the type of the move changes the text field and shows some
    * information 
    * <b>Postcondition:</b> based on the type of the move changes the text field and shows some
    * information
    * @param typeMove the type of the move that has happened
    * @param selectedPosition the starting position of each move
    * @param destinationPosition the final position of each move
    * @team the team of the piece name
    * @enemy the name of the enemy at the moves that require 2 pieces, one attacker one defender, at rescuing
    * enemy is used to show the label of the restored piece
    */
    public void textFieldIngame(int typeMove, int selectedPosition, int destinationPosition, String team, String enemy)
    {
            switch (typeMove) {
            case 0:
                infoInGame.setFont(
                                new java.awt.Font(game.getBoard().getPiece(selectedPosition).getClass().getSimpleName() + " " + team
                                                + " moved from " + selectedPosition + " to " + destinationPosition, Font.CENTER_BASELINE, 15));
                infoInGame.setText(game.getBoard().getPiece(selectedPosition).getClass().getSimpleName() + " " + team
                                + " moved from " + selectedPosition + " to " + destinationPosition);
                break;
            case 1:
                infoInGame.setFont(
                                new java.awt.Font(game.getBoard().getPiece(selectedPosition).getClass().getSimpleName() + " " + team
                                                + " attacked " + game.getBoard().getPiece(destinationPosition).getClass().getSimpleName()
                                                + " " + enemy + " both DIED", Font.CENTER_BASELINE, 15));
                infoInGame.setText(game.getBoard().getPiece(selectedPosition).getClass().getSimpleName() + " " + team
                                + " attacked " + game.getBoard().getPiece(destinationPosition).getClass().getSimpleName()
                                + " " + enemy + " both DIED");
                break;
            case 2:
                infoInGame.setFont(
                                new java.awt.Font(game.getBoard().getPiece(selectedPosition).getClass().getSimpleName() + " " + team
                                                + " attacked " + game.getBoard().getPiece(destinationPosition).getClass().getSimpleName()
                                                + " " + enemy + " and DIED", Font.CENTER_BASELINE, 15));
                infoInGame.setText(game.getBoard().getPiece(selectedPosition).getClass().getSimpleName() + " " + team
                                + " attacked " + game.getBoard().getPiece(destinationPosition).getClass().getSimpleName() + " "
                                + enemy + " and DIED");
                break;
            case 3:
                infoInGame.setFont(
                                new java.awt.Font(game.getBoard().getPiece(selectedPosition).getClass().getSimpleName() + " " + team
                                                + " attacked " + game.getBoard().getPiece(destinationPosition).getClass().getSimpleName()
                                                + " " + enemy + " and WON", Font.CENTER_BASELINE, 15));
                infoInGame.setText(game.getBoard().getPiece(selectedPosition).getClass().getSimpleName() + " " + team
                                + " attacked " + game.getBoard().getPiece(destinationPosition).getClass().getSimpleName() + " "
                                + enemy + " and WON");
                break;
            case 10:
                infoInGame.setFont(
                                new java.awt.Font(enemy + " (" + team + ") restored at " + destinationPosition, Font.CENTER_BASELINE, 15));
                infoInGame.setText(enemy + " (" + team + ") restored at " + destinationPosition);
                break;
            }


    }

    /**
    * <b>Transformer(mutative)</b>: checks if a button has been pushed, if there is a scout at the pushed button
    * or it is an empty one or a "lake one"
    * and configures the borders of all buttons as default and based on the above conditions configures the borders
    * of the above button's neighbors and it's
    * <b>Postcondition:</b> based on the type of the move changes the text field and shows some
    * information
    * @param but the button that has been pushed
    */
    public void setButtonsBorders(JButton but)
    {
        int i;
        for(i = 0; i<80; i++)
        {
                buttons[i].setBorder();
        }
        for(i = 0; i<80; i++)
        {
            if (game.isSquareEmpty(i)) {
                continue;
            }
            if (buttons[i].getButton() != but || ((game.getBoard().getPiece(i) instanceof Flag)
            || (game.getBoard().getPiece(i) instanceof Bomb))) {
                continue;
            }
            
            if (game.getBoard().getPiece(i).getRank() != 2) {
                if (i == 32 || i == 33 || i == 36 || i == 37 || i == 42 || i == 43 || i == 46 || i == 47) {
                    continue;
                }
                
                if (i < 70 && i != 22 && i != 23 && i != 26 && i != 27) {
                    if (game.getTurn() == COLOR.RED && "RED".equals(buttons[i].getTeam()) 
                    && buttons[i+10].getHid() != buttons[i+10].getHidRed()){
                        buttons[i + 10].setBorderAfterClicked();
                    }else if (game.getTurn() == COLOR.BLUE && "BLUE".equals(buttons[i].getTeam())
                    && buttons[i+10].getHid() != buttons[i+10].getHidBlue()){
                        buttons[i + 10].setBorderAfterClicked();
                    }
                }
                if (i > 9 && i != 52 && i != 53 && i != 56 && i != 57) {
                    if (game.getTurn() == COLOR.RED && "RED".equals(buttons[i].getTeam()) 
                    && buttons[i-10].getHid() != buttons[i-10].getHidRed()){
                        buttons[i - 10].setBorderAfterClicked();
                    }else if (game.getTurn() == COLOR.BLUE && "BLUE".equals(buttons[i].getTeam())
                    && buttons[i-10].getHid() != buttons[i-10].getHidBlue()){
                        buttons[i - 10].setBorderAfterClicked();
                    }
                }
                if (!(i == 0 || i == 10 || i == 20 || i == 30 || i == 40 || i == 50 || i == 60 || i == 70
                || i == 80 || i == 34 || i == 44 || i == 38 || i == 48)) {
                    if (game.getTurn() == COLOR.RED && "RED".equals(buttons[i].getTeam()) 
                    && buttons[i-1].getHid() != buttons[i-1].getHidRed()) {
                        buttons[i - 1].setBorderAfterClicked();
                    } else if (game.getTurn() == COLOR.BLUE && "BLUE".equals(buttons[i].getTeam())
                    && buttons[i-1].getHid() != buttons[i-1].getHidBlue()) {
                        buttons[i - 1].setBorderAfterClicked();
                    }
                }
                if (!(i == 9 || i == 19 || i == 29 || i == 39 || i == 49 || i == 59 || i == 69 || i == 79
                || i == 31 || i == 41 || i == 35 || i == 45)) {
                    if (game.getTurn() == COLOR.RED && "RED".equals(buttons[i].getTeam()) 
                    && buttons[i+1].getHid() != buttons[i+1].getHidRed()){
                        buttons[i + 1].setBorderAfterClicked();
                    }else if (game.getTurn() == COLOR.BLUE && "BLUE".equals(buttons[i].getTeam()) 
                    && buttons[i+1].getHid() != buttons[i+1].getHidBlue()){
                        buttons[i + 1].setBorderAfterClicked();
                    }
                }
            } else {
                if (game.getTurn() == COLOR.RED && "RED".equals(buttons[i].getTeam())) {
                    setBordersForScout(i, "BLUE");
                } else if (game.getTurn() == COLOR.BLUE && "BLUE".equals(buttons[i].getTeam())) {
                    setBordersForScout(i, "RED");
                }
            }
        }
    }

    /**
    * <b>Transformer(mutative)</b>: set's the borders of the squares that a scout can move
    * <b>Postcondition:</b> set's the borders of the squares that a scout can move 
    * @param i the position of the scout
    * @param oppTeam the enemy player/team
    */
    public void setBordersForScout(int i, String oppTeam) {
        if (i / 10 == 3 || i / 10 == 4) {
            if (i != 30 && i != 34 && i != 38 && i != 40 && i != 44 && i != 48) {
                buttons[i - 1].setBorderAfterClicked();
            } else {
                buttons[i + 1].setBorderAfterClicked();
            }
            for (int k = i; k > 9; k -= 10) {
                if (game.getBoard().getPiece(k - 10) == null || buttons[k - 10].getTeam().equals(oppTeam)) {
                    buttons[k - 10].setBorderAfterClicked();
                    if (buttons[k - 10].getTeam().equals(oppTeam)) {
                        break;
                    }
                } else {
                    break;
                }
            }
            for (int k = i; k < 70; k += 10) {
                if (game.getBoard().getPiece(k + 10) == null || buttons[k + 10].getTeam().equals(oppTeam)) {
                    buttons[k + 10].setBorderAfterClicked();
                    if (buttons[k + 10].getTeam().equals(oppTeam)) {
                        break;
                    }
                } else {
                    break;
                }
            }
        } else {
            for (int k = i; k > i - (i % 10); k--) {
                if (game.getBoard().getPiece(k - 1) == null || buttons[k - 1].getTeam().equals(oppTeam)) {
                    buttons[k - 1].setBorderAfterClicked();
                    if (buttons[k - 1].getTeam().equals(oppTeam)) {
                        break;
                    }
                } else {
                    break;
                }
            }
            for (int k = i; k < 79; k++) {
                if ((k + 1) / 10 > i / 10) {
                    break;
                }
                else if (game.getBoard().getPiece(k + 1) == null || buttons[k + 1].getTeam().equals(oppTeam)) {
                    buttons[k + 1].setBorderAfterClicked();
                    if (buttons[k + 1].getTeam().equals(oppTeam)) {
                        break;
                    }
                } else {
                    break;
                }
            }
            for (int k = i; k > 9; k -= 10) {
                if (game.getBoard().getPiece(k - 10) == null || buttons[k - 10].getTeam().equals(oppTeam)) {
                    if (k - 10 == 42 || k - 10 == 43 || k - 10 == 46 || k - 10 == 47) {
                        break;
                    }
                    buttons[k - 10].setBorderAfterClicked();
                    if (buttons[k - 10].getTeam().equals(oppTeam)) {
                        break;
                    }
                } else {
                    break;
                }
            }
            for (int k = i; k < 70; k += 10) {
                if (game.getBoard().getPiece(k + 10) == null || buttons[k + 10].getTeam().equals(oppTeam)) {
                    if (k + 10 == 32 || k + 10 == 33 || k + 10 == 36 || k + 10 == 37) {
                        break;
                    }
                    buttons[k + 10].setBorderAfterClicked();
                    if (buttons[k + 10].getTeam().equals(oppTeam)) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }

    /**
    * <b>Transformer(mutative)</b>:updates the view with the move the player wants to make
    * (if it is a valid one of course), checks some conditions that needs to be evaluated 
    * and if these are true then makes all the additional changes about the move as to the view,
    * also calls the playPiece method from controller in order to change 
    * there everything that is needed about the move except view-related stuff.
    * Also modifies the text field based on what move happened
    * <p><b>Postcondition:</b> updates the view with the move the player wants to make
    * (if it is a valid one of course), checks some conditions that needs to be evaluated 
    * and if these are true then makes all the additional changes about the move as to the view,
    * also calls the playPiece method from controller in order to change 
    * there everything that is needed about the move except view-related stuff.
    * Also modifies the text field based on what moved happened</p>
    * @param selected the selected button-piece
    * @param but the button-position the selected button-piece will move to
    */
    public void movePiece(PieceButton selected, JButton but) {
        int selectedPosition;
        if (selected != null) {
            selectedPosition = Integer.parseInt(selected.getButton().getName());
            int destinationPosition;
            
            if (((Integer.parseInt(but.getName()) + 10) == selectedPosition
            || (Integer.parseInt(but.getName()) - 10) == selectedPosition
            || (Integer.parseInt(but.getName()) - 1) == selectedPosition
            || (Integer.parseInt(but.getName()) + 1) == selectedPosition
            && (game.getBoard().getPiece(selectedPosition) != null
            && game.getBoard().getPiece(selectedPosition).getRank() != 2)) 
            || 
            (game.getBoard().getPiece(selectedPosition) != null
            && game.getBoard().getPiece(selectedPosition).getRank() == 2
            && ((Integer.parseInt(but.getName()) / 10 == selectedPosition / 10)
            || (Integer.parseInt(but.getName()) % 10 == selectedPosition % 10)))) {

                destinationPosition = Integer.parseInt(but.getName());

                if (!game.isSquareEmpty(selectedPosition) && destinationPosition != -1 && destinationPosition != 32
                        && destinationPosition != 33 && destinationPosition != 36 && destinationPosition != 37
                        && destinationPosition != 42 && destinationPosition != 43 && destinationPosition != 46
                        && destinationPosition != 47 && game.getBoard().getPiece(selectedPosition).getRank() != 0) {
                        if ("BLUE".equals(selected.getTeam()) && game.getTurn() == COLOR.BLUE
                            && (buttons[destinationPosition].getHid() == null
                            || "RED".equals(buttons[destinationPosition].getTeam()))) {
                            
                            if(buttons[destinationPosition].getHid() == null)
                            {
                                textFieldIngame(0, selectedPosition, destinationPosition, "BLUE", "RED");
                                buttons[destinationPosition].setBlueHidden();
                                buttons[destinationPosition].setVis(COLOR.BLUE, buttons[selectedPosition].getVis());
                                buttons[selectedPosition].setNoIcon();
                                game.playPiece(selectedPosition, destinationPosition, COLOR.RED,0);
                            } else if((game.getBoard().getPiece(selectedPosition).getRank() 
                            > game.getBoard().getPiece(destinationPosition).getRank() 
                            && !(game.getBoard().getPiece(destinationPosition) instanceof Bomb))
                            || (game.getBoard().getPiece(selectedPosition) instanceof Slayer
                                            && game.getBoard().getPiece(destinationPosition) instanceof Dragon)
                            || (game.getBoard().getPiece(selectedPosition) instanceof Dwarf
                                            && game.getBoard().getPiece(destinationPosition) instanceof Bomb)
                            ) {
                                textFieldIngame(3, selectedPosition, destinationPosition, "BLUE", "RED");
                                buttons[destinationPosition].setBlueHidden();
                                buttons[destinationPosition].setVis(COLOR.BLUE, buttons[selectedPosition].getVis());
                                buttons[selectedPosition].setNoIcon();
                                game.playPiece(selectedPosition, destinationPosition, COLOR.RED,3);
                            } else if(game.getBoard().getPiece(selectedPosition).getRank() 
                            == game.getBoard().getPiece(destinationPosition).getRank()) {
                                textFieldIngame(1, selectedPosition, destinationPosition, "BLUE", "RED");
                                buttons[selectedPosition].setNoIcon();
                                buttons[destinationPosition].setNoIcon();
                                game.playPiece(selectedPosition, destinationPosition, COLOR.RED,1);
                            } else if(game.getBoard().getPiece(selectedPosition).getRank() 
                            < game.getBoard().getPiece(destinationPosition).getRank()
                            || (game.getBoard().getPiece(destinationPosition) instanceof Bomb)) {
                                textFieldIngame(2, selectedPosition, destinationPosition, "BLUE", "RED");
                                buttons[selectedPosition].setNoIcon();
                                game.playPiece(selectedPosition, destinationPosition, COLOR.RED,2);
                            }
                    } else if ("RED".equals(selected.getTeam()) && game.getTurn() == COLOR.RED
                    && (buttons[destinationPosition].getHid() == null
                    ||  "BLUE".equals(buttons[destinationPosition].getTeam()))) {
                        if(buttons[destinationPosition].getHid() == null) {
                            textFieldIngame(0, selectedPosition, destinationPosition, "RED", "BLUE");
                            buttons[destinationPosition].setRedHidden();
                            buttons[destinationPosition].setVis(COLOR.RED, buttons[selectedPosition].getVis());
                            buttons[selectedPosition].setNoIcon();
                            game.playPiece(selectedPosition, destinationPosition, COLOR.BLUE,0);
                        } else if((game.getBoard().getPiece(selectedPosition).getRank() 
                        > game.getBoard().getPiece(destinationPosition).getRank()
                        && !(game.getBoard().getPiece(destinationPosition) instanceof Bomb))
                        || (game.getBoard().getPiece(selectedPosition) instanceof Slayer
                        && game.getBoard().getPiece(destinationPosition) instanceof Dragon)
                        || (game.getBoard().getPiece(selectedPosition) instanceof Dwarf
                        && game.getBoard().getPiece(destinationPosition) instanceof Bomb)){
                            textFieldIngame(3, selectedPosition, destinationPosition, "RED", "BLUE");
                            buttons[destinationPosition].setRedHidden();
                            buttons[destinationPosition].setVis(COLOR.RED, buttons[selectedPosition].getVis());
                            buttons[selectedPosition].setNoIcon();
                            game.playPiece(selectedPosition, destinationPosition, COLOR.BLUE,3);
                        } else if(game.getBoard().getPiece(selectedPosition).getRank() 
                        == game.getBoard().getPiece(destinationPosition).getRank()) {
                            textFieldIngame(1, selectedPosition, destinationPosition, "RED", "BLUE");
                            buttons[selectedPosition].setNoIcon();
                            buttons[destinationPosition].setNoIcon();
                            game.playPiece(selectedPosition, destinationPosition, COLOR.BLUE,1);
                        } else if(game.getBoard().getPiece(selectedPosition).getRank() 
                        < game.getBoard().getPiece(destinationPosition).getRank()
                        || (game.getBoard().getPiece(destinationPosition) instanceof Bomb)){
                            textFieldIngame(2, selectedPosition, destinationPosition, "RED", "BLUE");
                            buttons[selectedPosition].setNoIcon();
                            game.playPiece(selectedPosition, destinationPosition, COLOR.BLUE,2);
                        }
                    }
                }
            }
        }
    }

    @SuppressWarnings("unused")
    public static void main(String[] args)
    {
        view v = new view();
    }
}
