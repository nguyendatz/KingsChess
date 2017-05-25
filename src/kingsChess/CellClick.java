package kingsChess;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

import javax.swing.JButton;

public class CellClick implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		String chessId = btn.getActionCommand();
		User user = User.getCurrent();
		
		Cell selectCell = user.ListCells.stream()
	    		.filter(p -> p.Id.toString().equals(chessId))
	    		.findFirst()
	    		.orElse(new Cell());
		
		if(user.SelectCell == null)
		{
			if(selectCell.Name == null) return;
			
		    user.SelectCell = selectCell;
		}
		else
		{
			if(selectCell.Name != null) return;
			
			selectCell.Image = user.SelectCell.Image;
			selectCell.Button.setIcon(user.SelectCell.Image);
			selectCell.Name = user.SelectCell.Name;
			
			user.SelectCell.Image = null;
			user.SelectCell.Name = null;
			user.SelectCell.Button.setIcon(null);
					
			user.SelectCell = null;
		}
	}
}