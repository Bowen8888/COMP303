package Bridge;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Bridge.Card.Rank;



/**
 * Graphical window to display composite icons.
 */
@SuppressWarnings("serial")
public class BridgeDealer extends JFrame
{
	
	private final Deck aDeck;
	
	/**
	 * Builds and launches the window.
	 */
	public BridgeDealer()
	{
		super("Bridge Hand Dealer \u00A9 Martin Robillard 2017");
		
		aDeck = new Deck();
		
		final HandPanel aNorth = new HandPanel();
		final HandPanel aSouth = new HandPanel();
		
		JPanel lPanel = new JPanel();
		lPanel.setLayout(new GridLayout(2, 1));
		lPanel.add(aNorth);
		lPanel.add(aSouth);
		setLayout(new BorderLayout());
		add(lPanel, BorderLayout.CENTER);
		
		final JButton deal = new JButton("Deal");
		add(deal, BorderLayout.SOUTH);
		deal.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent pEvent)
			{
				aDeck.shuffle();	
				aNorth.showHand(dealHand());
				aSouth.showHand(dealHand());
			}
		});
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setResizable(false);
		setVisible(true);
	}

	/**
	 * @param pArgs Not used.
	 */
	public static void main(String[] pArgs)
	{
		new BridgeDealer();
	}
	
	private Card[] dealHand()
	{
		Card[] lReturn = new Card[Rank.values().length];
		for( int i = 0; i < Rank.values().length; i++)
		{
			lReturn[i] = aDeck.draw();
		}
		return lReturn;
	}
}

/**
 * A graphical panel that shows one hand.
 */
class HandPanel extends JPanel
{
	private static final Color CASINO_GREEN = new Color(0, 102, 0);
	
	private static final long serialVersionUID = 1L;

	private static final int SHIFT = 30;
	
	private JLabel aLabel = new JLabel();
	
	/**
	 * Create the panel with the icon in it.
	 * Initially should show 13 times the back of a card.
	 */
	HandPanel()
	{
		setBackground(CASINO_GREEN);
		add(aLabel);
		Icon icon = new CompositeIcon(SHIFT, CardImages.getBack(), CardImages.getBack(), CardImages.getBack(), CardImages.getBack(), CardImages.getBack(), CardImages.getBack(), CardImages.getBack(), CardImages.getBack(), CardImages.getBack(), CardImages.getBack(), CardImages.getBack(), CardImages.getBack(), CardImages.getBack()); // TODO Correctly initialize a single icon that represents the back of 13 cards
		
		aLabel.setIcon(icon);
	}
	
	public void showHand(Card[] pHand)
	{
		List<Icon> icons = new ArrayList<Icon>();
		for(Card card : pHand)
		{
			icons.add(CardImages.getCard(card));
		}
		Icon icon = new CompositeIcon(SHIFT,icons); 
		aLabel.setIcon(icon);
	}
}