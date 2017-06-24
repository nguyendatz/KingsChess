package kingsChess;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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
			if (go == true) {
				CellChange change = new CellChange();
				change.OldCell = user.SelectCell.Id.toString();
				change.NewCell = selectCell.Id.toString();				
				DataTransfer data = new DataTransfer(change);
				data.sendToServer();
				user.SelectCell = null;
			} else {
				System.out.println("Can't go");
			}

		}
	}
}