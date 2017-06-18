package kingsChess;

import java.awt.Color;
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

		Cell selectCell = user.ListCells.stream().filter(p -> p.Id.toString().equals(chessId)).findFirst()
				.orElse(new Cell());
		if (user.SelectCell == null) // chua click lan nao
		{
			if (selectCell.Name == null)
				return;

			// selectCell.Button.setBackground(Color.decode("#0066ff"));
			user.SelectCell = selectCell;
		}

		else // click lan 2
		{
                        CheckGo check = new CheckGo();
                        boolean go = check.canGo(user, selectCell);
                        if(go == true){
                                        selectCell.Image = user.SelectCell.Image;// cho moi
					selectCell.Button.setIcon(user.SelectCell.Image);
					selectCell.Name = user.SelectCell.Name;
                                        if (user.SelectCell.type.equals("trang")) {
						selectCell.type = "trang";
					} else {
						selectCell.type = "den";
					}
					user.SelectCell.Image = null; // cho cu
					user.SelectCell.Name = null;
					user.SelectCell.Button.setIcon(null);
					user.SelectCell.type = null;
					user.SelectCell = null;
					
                        }
                        else{
                            System.out.println("Can't go");
                        }
			
		}
	}
}