package view;

import java.awt.Color;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;

import model.Player.Player.COLOR;

/**
* PieceButton is the class that will extend a JButton with some more things we want
* @version 1.0
* @author Pavlos Tzegiannakis - csd3470
*/

public class PieceButton {

    /**
    * Blue icons below
    */
    public Icon hidBlue = new ImageIcon(getClass().getResource("/images/bluePieces/blueHidden.png"));
    public Image hidBlueimg = ((ImageIcon) hidBlue).getImage();
    public Image hidBlue_newimg = hidBlueimg.getScaledInstance( 80, 60,  java.awt.Image.SCALE_SMOOTH );

    public Icon beastRiderB = new ImageIcon(getClass().getResource("/images/bluePieces/beastRiderB.png"));
    public Image beastRiderBimg = ((ImageIcon) beastRiderB).getImage();
    public Image beastRiderB_newimg = beastRiderBimg.getScaledInstance( 80, 60,  java.awt.Image.SCALE_SMOOTH );  

    public Icon dragonB = new ImageIcon(getClass().getResource("/images/bluePieces/dragonB.png"));
    public Image dragonBimg = ((ImageIcon) dragonB).getImage();
    public Image dragonB_newimg = dragonBimg.getScaledInstance( 80, 60,  java.awt.Image.SCALE_SMOOTH );  

    public Icon dwarfB = new ImageIcon(getClass().getResource("/images/bluePieces/dwarfB.png"));
    public Image dwarfBimg = ((ImageIcon) dwarfB).getImage();
    public Image dwarfB_newimg = dwarfBimg.getScaledInstance( 80, 60,  java.awt.Image.SCALE_SMOOTH );  

    public Icon elfB = new ImageIcon(getClass().getResource("/images/bluePieces/elfB.png"));
    public Image elfBimg = ((ImageIcon) elfB).getImage();
    public Image elfB_newimg = elfBimg.getScaledInstance( 80, 60,  java.awt.Image.SCALE_SMOOTH );  

    public Icon flagB = new ImageIcon(getClass().getResource("/images/bluePieces/flagB.png"));
    public Image flagBimg = ((ImageIcon) flagB).getImage();
    public Image flagB_newimg = flagBimg.getScaledInstance( 80, 60,  java.awt.Image.SCALE_SMOOTH );  

    public Icon knightB = new ImageIcon(getClass().getResource("/images/bluePieces/knightB.png"));
    public Image knightBimg = ((ImageIcon) knightB).getImage();
    public Image knightB_newimg = knightBimg.getScaledInstance( 80, 60,  java.awt.Image.SCALE_SMOOTH );  

    public Icon mageB = new ImageIcon(getClass().getResource("/images/bluePieces/mageB.png"));
    public Image mageBimg = ((ImageIcon) mageB).getImage();
    public Image mageB_newimg = mageBimg.getScaledInstance( 80, 60,  java.awt.Image.SCALE_SMOOTH );  

    public Icon scoutB = new ImageIcon(getClass().getResource("/images/bluePieces/scoutB.png"));
    public Image scoutBimg = ((ImageIcon) scoutB).getImage();
    public Image scoutB_newimg = scoutBimg.getScaledInstance( 80, 60,  java.awt.Image.SCALE_SMOOTH );  

    public Icon slayerB = new ImageIcon(getClass().getResource("/images/bluePieces/slayerB.png"));
    public Image slayerBimg = ((ImageIcon) slayerB).getImage();
    public Image slayerB_newimg = slayerBimg.getScaledInstance( 80, 60,  java.awt.Image.SCALE_SMOOTH );  

    public Icon sorceressB = new ImageIcon(getClass().getResource("/images/bluePieces/sorceressB.png"));
    public Image sorceressBimg = ((ImageIcon) sorceressB).getImage();
    public Image sorceressB_newimg = sorceressBimg.getScaledInstance( 80, 60,  java.awt.Image.SCALE_SMOOTH );  

    public Icon trapB = new ImageIcon(getClass().getResource("/images/bluePieces/trapB.png"));
    public Image trapBimg = ((ImageIcon) trapB).getImage();
    public Image trapB_newimg = trapBimg.getScaledInstance( 80, 60,  java.awt.Image.SCALE_SMOOTH );  

    public Icon yeti = new ImageIcon(getClass().getResource("/images/bluePieces/yeti.png"));
    public Image yetiimg = ((ImageIcon) yeti).getImage();
    public Image yeti_newimg = yetiimg.getScaledInstance( 80, 60,  java.awt.Image.SCALE_SMOOTH );  

    /**
    * Red icons below
    */
    public Icon hidRed = new ImageIcon(getClass().getResource("/images/redPieces/redHidden.png"));
    public Image hidRedimg = ((ImageIcon) hidRed).getImage();
    public Image hidRed_newimg = hidRedimg.getScaledInstance( 80, 60,  java.awt.Image.SCALE_SMOOTH ); 

    public Icon beastRiderR = new ImageIcon(getClass().getResource("/images/redPieces/beastRiderR.png"));
    public Image beastRiderRimg = ((ImageIcon) beastRiderR).getImage();
    public Image beastRiderR_newimg = beastRiderRimg.getScaledInstance( 80, 60,  java.awt.Image.SCALE_SMOOTH );  

    public Icon dragonR = new ImageIcon(getClass().getResource("/images/redPieces/dragonR.png"));
    public Image dragonRimg = ((ImageIcon) dragonR).getImage();
    public Image dragonR_newimg = dragonRimg.getScaledInstance( 80, 60,  java.awt.Image.SCALE_SMOOTH );  

    public Icon dwarfR = new ImageIcon(getClass().getResource("/images/redPieces/dwarfR.png"));
    public Image dwarfRimg = ((ImageIcon) dwarfR).getImage();
    public Image dwarfR_newimg = dwarfRimg.getScaledInstance( 80, 60,  java.awt.Image.SCALE_SMOOTH );  

    public Icon elfR = new ImageIcon(getClass().getResource("/images/redPieces/elfR.png"));
    public Image elfRimg = ((ImageIcon) elfR).getImage();
    public Image elfR_newimg = elfRimg.getScaledInstance( 80, 60,  java.awt.Image.SCALE_SMOOTH );  

    public Icon flagR = new ImageIcon(getClass().getResource("/images/redPieces/flagR.png"));
    public Image flagRimg = ((ImageIcon) flagR).getImage();
    public Image flagR_newimg = flagRimg.getScaledInstance( 80, 60,  java.awt.Image.SCALE_SMOOTH );  

    public Icon knightR = new ImageIcon(getClass().getResource("/images/redPieces/knightR.png"));
    public Image knightRimg = ((ImageIcon) knightR).getImage();
    public Image knightR_newimg = knightRimg.getScaledInstance( 80, 60,  java.awt.Image.SCALE_SMOOTH );  

    public Icon mageR = new ImageIcon(getClass().getResource("/images/redPieces/mageR.png"));
    public Image mageRimg = ((ImageIcon) mageR).getImage();
    public Image mageR_newimg = mageRimg.getScaledInstance( 80, 60,  java.awt.Image.SCALE_SMOOTH );  

    public Icon scoutR = new ImageIcon(getClass().getResource("/images/redPieces/scoutB.png"));
    public Image scoutRimg = ((ImageIcon) scoutR).getImage();
    public Image scoutR_newimg = scoutRimg.getScaledInstance( 80, 60,  java.awt.Image.SCALE_SMOOTH );  

    public Icon slayerR = new ImageIcon(getClass().getResource("/images/redPieces/slayerR.png"));
    public Image slayerRimg = ((ImageIcon) slayerR).getImage();
    public Image slayerR_newimg = slayerRimg.getScaledInstance( 80, 60,  java.awt.Image.SCALE_SMOOTH );  

    public Icon sorceressR = new ImageIcon(getClass().getResource("/images/redPieces/sorceressR.png"));
    public Image sorceressRimg = ((ImageIcon) sorceressR).getImage();
    public Image sorceressR_newimg = sorceressRimg.getScaledInstance( 80, 60,  java.awt.Image.SCALE_SMOOTH );  

    public Icon trapR = new ImageIcon(getClass().getResource("/images/redPieces/trapR.png"));
    public Image trapRimg = ((ImageIcon) trapR).getImage();
    public Image trapR_newimg = trapRimg.getScaledInstance( 80, 60,  java.awt.Image.SCALE_SMOOTH );  

    public Icon lavaBeast = new ImageIcon(getClass().getResource("/images/redPieces/lavaBeast.png"));
    public Image lavaBeastimg = ((ImageIcon) lavaBeast).getImage();
    public Image lavaBeast_newimg = lavaBeastimg.getScaledInstance( 80, 60,  java.awt.Image.SCALE_SMOOTH );

    /**
     * Variables
     */
    private JButton button;
    private Icon visBlue;
    private Icon visRed;
    private String team = "";
    private final Icon[] icons = new Icon[2];

    /**
    * <b>Constructor</b>: Creates a new PieceButton with the appropriate name and initializes some icons
    * <b>Postcondition</b>: Creates a new PieceButton with the appropriate as name and initializes some icons
    */
    public PieceButton(String name)
    {
        button = new JButton("");
        button.setName(name);
        initIcons();
    }

    /**
    * <b>Transformer(mutative)</b>:initializes some icons after a PieceButton has been created
    * <b>Postcondition:</b> initializes some icons after a PieceButton has been created
    */
    public void initIcons()
    {
        hidBlue = new ImageIcon(hidBlue_newimg ,"hidBlue");
        beastRiderB = new ImageIcon(beastRiderB_newimg ,"beastRiderB");
        dragonB = new ImageIcon(dragonB_newimg ,"dragonB");
        dwarfB = new ImageIcon(dwarfB_newimg ,"dwarfB");
        elfB = new ImageIcon(elfB_newimg ,"elfB");
        flagB = new ImageIcon(flagB_newimg ,"flagB");
        knightB = new ImageIcon(knightB_newimg ,"knightB");
        mageB = new ImageIcon(mageB_newimg ,"mageB");
        scoutB = new ImageIcon(scoutB_newimg ,"scoutB");
        slayerB = new ImageIcon(slayerB_newimg ,"slayerB");
        sorceressB = new ImageIcon(sorceressB_newimg ,"sorceressB");
        trapB = new ImageIcon(trapB_newimg ,"trapB");
        yeti = new ImageIcon(yeti_newimg ,"yeti");


        hidRed = new ImageIcon(hidRed_newimg, "hidRed");
        beastRiderR = new ImageIcon(beastRiderR_newimg ,"beastRiderR");
        dragonR = new ImageIcon(dragonR_newimg ,"dragonR");
        dwarfR = new ImageIcon(dwarfR_newimg ,"dwarfR");
        elfR = new ImageIcon(elfR_newimg ,"elfR");
        flagR = new ImageIcon(flagR_newimg ,"flagR");
        knightR = new ImageIcon(knightR_newimg ,"knightR");
        mageR = new ImageIcon(mageR_newimg ,"mageR");
        scoutR = new ImageIcon(scoutR_newimg ,"scoutR");
        slayerR = new ImageIcon(slayerR_newimg ,"slayerR");
        sorceressR = new ImageIcon(sorceressR_newimg ,"sorceressR");
        trapR = new ImageIcon(trapR_newimg ,"trapR");
        lavaBeast = new ImageIcon(lavaBeast_newimg ,"lavaBeast");
    }

    /**
    * <b>Transformer(mutative)</b>:sets the PieceButton's button's background colour
    * <b>Postcondition:</b> sets the PieceButton's button's background colour
    */
    public void setBGColor(Color c)
    {
        button.setBackground(c);
    }

    /**
    * <b>Transformer(mutative)</b>:sets the PieceButton's button
    * <b>Postcondition:</b> sets the PieceButton's button
    */
    public void setButton(JButton b)
    {
        button = b;
    }

    /**
    * <b>accessor(selector)</b>:returns the button of the PieceButton
    * <b>Postcondition:</b> returns the button of the PieceButton
    * @return the button of the PieceButton
    */
    public JButton getButton()
    {
        return button;
    }

    /**
    * <b>Transformer(mutative)</b>:sets the PieceButton's button's hidden icon as hidRed and icons[0] as hidRed
    * <b>Postcondition:</b> sets the PieceButton's button's hidden icon as hidRed and icons[0] as hidRed
    */
    public void setRedHidden()
    {
        button.setIcon(hidRed);
        setHid(hidRed);
    }

    /**
    * <b>Transformer(mutative)</b>:sets the PieceButton's button's hidden icon as hidBlue and icons[0] as hidBlue
    * <b>Postcondition:</b> sets the PieceButton's button's hidden icon as hidBlue and icons[0] as hidBlue
    */
    public void setBlueHidden()
    {
        button.setIcon(hidBlue);
        setHid(hidBlue);
    }

    /**
    * <b>Transformer(mutative)</b>:sets the PieceButton's button's red visible icon as appropriate in the start of a game
    * <b>Postcondition:</b> sets the PieceButton's button's red visible icon as appropriate in the start of a game
    * @param i position of the square at the board
    */
    public void setFirstRedVisible(int i)
    {
        switch (i) {
            case 50:
                visRed = new ImageIcon(trapR_newimg, "visRed");
                button.setIcon(trapR);
                setVis(COLOR.RED,visRed);
                break;
            case 51:
                visRed = knightR;
                button.setIcon(knightR);
                setVis(COLOR.RED,visRed);
                break;
            case 52:
                visRed = beastRiderR;
                button.setIcon(beastRiderR);
                setVis(COLOR.RED,visRed);
                break;
            case 53:
                visRed = trapR;
                button.setIcon(trapR);
                setVis(COLOR.RED,visRed);
                break;
            case 54:
                visRed = dwarfR;
                button.setIcon(dwarfR);
                setVis(COLOR.RED,visRed);
                break;
            case 55:
                visRed = trapR;
                button.setIcon(trapR);
                setVis(COLOR.RED,visRed);
                break;
            case 56:
                visRed = beastRiderR;
                button.setIcon(beastRiderR);
                setVis(COLOR.RED,visRed);
                break;
            case 57:
                visRed = dwarfR;
                button.setIcon(dwarfR);
                setVis(COLOR.RED,visRed);
                break;
            case 58:
                visRed = scoutR;
                button.setIcon(scoutR);
                setVis(COLOR.RED,visRed);
                break;
            case 59:
                visRed = elfR;
                button.setIcon(elfR);
                setVis(COLOR.RED,visRed);
                break;
            case 60:
                visRed = trapR;
                button.setIcon(trapR);
                setVis(COLOR.RED,visRed);
                break;
            case 61:
                visRed = trapR;
                button.setIcon(trapR);
                setVis(COLOR.RED,visRed);
                break;
            case 62:
                visRed = slayerR;
                button.setIcon(slayerR);
                setVis(COLOR.RED,visRed);
                break;
            case 63:
                visRed = elfR;
                button.setIcon(elfR);
                setVis(COLOR.RED,visRed);
                break;
            case 64:
                visRed = knightR;
                button.setIcon(knightR);
                setVis(COLOR.RED,visRed);
                break;
            case 65:
                visRed = flagR;
                button.setIcon(flagR);
                setVis(COLOR.RED,visRed);
                break;
            case 66:
                visRed = scoutR;
                button.setIcon(scoutR);
                setVis(COLOR.RED,visRed);
                break;
            case 67:
                visRed = dragonR;
                button.setIcon(dragonR);
                setVis(COLOR.RED,visRed);
                break;
            case 68:
                visRed = scoutR;
                button.setIcon(scoutR);
                setVis(COLOR.RED,visRed);
                break;
            case 69:
                visRed = beastRiderR;
                button.setIcon(beastRiderR);
                setVis(COLOR.RED,visRed);
                break;
            case 70:
                visRed = dwarfR;
                button.setIcon(dwarfR);
                setVis(COLOR.RED,visRed);
                break;
            case 71:
                visRed = trapR;
                button.setIcon(trapR);
                setVis(COLOR.RED,visRed);
                break;
            case 72:
                visRed = lavaBeast;
                button.setIcon(lavaBeast);
                setVis(COLOR.RED,visRed);
                break;
            case 73:
                visRed = scoutR;
                button.setIcon(scoutR);
                setVis(COLOR.RED,visRed);
                break;
            case 74:
                visRed = sorceressR;
                button.setIcon(sorceressR);
                setVis(COLOR.RED,visRed);
                break;
            case 75:
                visRed = lavaBeast;
                button.setIcon(lavaBeast);
                setVis(COLOR.RED,visRed);
                break;
            case 76:
                visRed = sorceressR;
                button.setIcon(sorceressR);
                setVis(COLOR.RED,visRed);
                break;
            case 77:
                visRed = dwarfR;
                button.setIcon(dwarfR);
                setVis(COLOR.RED,visRed);
                break;
            case 78:
                visRed = dwarfR;
                button.setIcon(dwarfR);
                setVis(COLOR.RED,visRed);
                break;
            case 79:
                visRed = mageR;
                button.setIcon(mageR);
                setVis(COLOR.RED,visRed);
                break;
            default:
                break;
        }
    }

    /**
    * <b>Transformer(mutative)</b>:sets the PieceButton's button's blue visible icon as appropriate in the start of a game
    * <b>Postcondition:</b> sets the PieceButton's button's blue visible icon as appropriate in the start of a game
    * @param i position of the square at the board
    */
    public void setFirstBlueVisible(int i)
    {
        switch (i) {
            case 0:
                visBlue = trapB;
                button.setIcon(trapB);
                setVis(COLOR.BLUE,visBlue);
                break;
            case 1:
                visBlue = dwarfB;
                button.setIcon(dwarfB);
                setVis(COLOR.BLUE,visBlue);
                break;
            case 2:
                visBlue = scoutB;
                button.setIcon(scoutB);
                setVis(COLOR.BLUE,visBlue);
                break;
            case 3:
                visBlue = dwarfB;
                button.setIcon(dwarfB);
                setVis(COLOR.BLUE,visBlue);
                break;
            case 4:
                visBlue = yeti;
                button.setIcon(yeti);
                setVis(COLOR.BLUE,visBlue);
                break;
            case 5:
                visBlue = flagB;
                button.setIcon(flagB);
                setVis(COLOR.BLUE,visBlue);
                break;
            case 6:
                visBlue = sorceressB;
                button.setIcon(sorceressB);
                setVis(COLOR.BLUE,visBlue);
                break;
            case 7:
                visBlue = trapB;
                button.setIcon(trapB);
                setVis(COLOR.BLUE,visBlue);
                break;
            case 8:
                visBlue = yeti;
                button.setIcon(yeti);
                setVis(COLOR.BLUE,visBlue);
                break;
            case 9:
                visBlue = dwarfB;
                button.setIcon(dwarfB);
                setVis(COLOR.BLUE,visBlue);
                break;
            case 10:
                visBlue = trapB;
                button.setIcon(trapB);
                setVis(COLOR.BLUE,visBlue);
                break;
            case 11:
                visBlue = dragonB;
                button.setIcon(dragonB);
                setVis(COLOR.BLUE,visBlue);
                break;
            case 12:
                visBlue = scoutB;
                button.setIcon(scoutB);
                setVis(COLOR.BLUE,visBlue);
                break;
            case 13:
                visBlue = mageB;
                button.setIcon(mageB);
                setVis(COLOR.BLUE,visBlue);
                break;
            case 14:
                visBlue = trapB;
                button.setIcon(trapB);
                setVis(COLOR.BLUE,visBlue);
                break;
            case 15:
                visBlue = elfB;
                button.setIcon(elfB);
                setVis(COLOR.BLUE,visBlue);
                break;
            case 16:
                visBlue = knightB;
                button.setIcon(knightB);
                setVis(COLOR.BLUE,visBlue);
                break;
            case 17:
                visBlue = beastRiderB;
                button.setIcon(beastRiderB);
                setVis(COLOR.BLUE,visBlue);
                break;
            case 18:
                visBlue = scoutB;
                button.setIcon(scoutB);
                setVis(COLOR.BLUE,visBlue);
                break;
            case 19:
                visBlue = beastRiderB;
                button.setIcon(beastRiderB);
                setVis(COLOR.BLUE,visBlue);
                break;
            case 20:
                visBlue = beastRiderB;
                button.setIcon(beastRiderB);
                setVis(COLOR.BLUE,visBlue);
                break;
            case 21:
                visBlue = trapB;
                button.setIcon(trapB);
                setVis(COLOR.BLUE,visBlue);
                break;
            case 22:
                visBlue = dwarfB;
                button.setIcon(dwarfB);
                setVis(COLOR.BLUE,visBlue);
                break;
            case 23:
                visBlue = scoutB;
                button.setIcon(scoutB);
                setVis(COLOR.BLUE,visBlue);
                break;
            case 24:
                visBlue = elfB;
                button.setIcon(elfB);
                setVis(COLOR.BLUE,visBlue);
                break;
            case 25:
                visBlue = sorceressB;
                button.setIcon(sorceressB);
                setVis(COLOR.BLUE,visBlue);
                break;
            case 26:
                visBlue = knightB;
                button.setIcon(knightB);
                setVis(COLOR.BLUE,visBlue);
                break;
            case 27:
                visBlue = trapB;
                button.setIcon(trapB);
                setVis(COLOR.BLUE,visBlue);
                break;
            case 28:
                visBlue = dwarfB;
                button.setIcon(dwarfB);
                setVis(COLOR.BLUE,visBlue);
                break;
            case 29:
                visBlue = slayerB;
                button.setIcon(slayerB);
                setVis(COLOR.BLUE,visBlue);
                break;
            default:
                break;
        }
    }

    /**
    * <b>Transformer(mutative)</b>:sets the PieceButton's button's icon as null and icons[0,1] as null, 
    * also team of the PieceButton now is equal to "" (means no team)
    * <b>Postcondition:</b> sets the PieceButton's button's icon as null and icons[0,1] as null, 
    * also team of the PieceButton now is equal to "" (means no team)
    */
    public void setNoIcon()
    {
        button.setIcon(null);
        setHid(null);
        setVis(null,null);
        team = "";
    }

    /**
    * <b>accessor(selector)</b>:changes and returns the team of the PieceButton
    * <b>Postcondition:</b> changes and returns the team of the PieceButton
    * @return the team of the PieceButton
    */
    public String getTeam()
    {
        if (icons[0] == hidRed || "RED".equals(team)){
            team = "RED";
        } else if(icons[0] == hidBlue || "BLUE".equals(team)) {
            team = "BLUE";
        } else {
            team = "EMPTY SQUARE- NO TEAM";
        }
        return team;
    }

    /**
    * <b>Transformer(mutative)</b>:sets the PieceButton's button's borders as default
    * <b>Postcondition:</b> sets the PieceButton's button's borders as default 
    */
    public void setBorder()
    {
        button.setBorder(UIManager.getBorder("Button.border"));
    }

    /**
    * <b>Transformer(mutative)</b>:sets the PieceButton's button's borders as a possible destination
    * <b>Postcondition:</b> sets the PieceButton's button's borders as a possible destination
    */
    public void setBorderAfterClicked()
    {
        button.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
    }

    /**
    * <b>Transformer(mutative)</b>:sets the PieceButton's button's hidden icon as hid 
    * <b>Postcondition:</b> sets the PieceButton's button's hidden icon as hid
    * @param hid the Icon that we will store at icons[0]
    */
    public void setHid(Icon hid)
    {
        icons[0] = hid;
    }

    /**
    * <b>Transformer(mutative)</b>:sets the PieceButton's button's visible icon as vis 
    * and changes the team of the PieceButton
    * <b>Postcondition:</b> sets the PieceButton's button's visible icon as vis 
    * and changes the team of the PieceButton
    * @param team the player/team that we will change to the class' team variable
    * @param vis the Icon that we will store at icons[1]
    */
    public void setVis(COLOR team, Icon vis)
    {
        if(team == COLOR.RED){
            this.team = "RED";
        } else if(team == COLOR.BLUE) {
            this.team = "BLUE";
        }
        button.setIcon(vis);
        icons[1] = vis;
    }

    /**
    * <b>accessor(selector)</b>:returns the hidden icon of the PieceButton
    * <b>Postcondition:</b> returns the hidden icon of the PieceButton
    * @return the hidden icon of the PieceButton
    */
    public Icon getHid()
    {
        return icons[0];
    }

    /**
    * <b>accessor(selector)</b>:returns the visible icon of the PieceButton
    * <b>Postcondition:</b> returns the visible icon of the PieceButton
    * @return the visible icon of the PieceButton
    */
    public Icon getVis()
    {
        return icons[1];
    }

    /**
    * <b>accessor(selector)</b>:returns hidRed, red hidden icon
    * <b>Postcondition:</b> returns hidRed, red hidden icon
    * @return hidRed, red hidden icon
    */
    public Icon getHidRed()
    {
        return hidRed;
    }

    /**
    * <b>accessor(selector)</b>:returns hidBlue, blue hidden icon 
    * <b>Postcondition:</b> returns hidBlue, blue hidden icon
    * @return hidBlue, blue hidden icon
    */
    public Icon getHidBlue()
    {
        return hidBlue;
    }

    /**
    * <b>Observer</b>:Returns if a PieceButton has icons stored
    * <b>Postcondition:</b> Returns if a PieceButton has icons stored
    * @return true if a PieceButton has icons stored, false otherwise
    */
    public boolean hasIcon()
    {
        return !(icons[0] == null || icons[1] == null);
    }
}
