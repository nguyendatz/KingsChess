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
			selectCell.Image = user.SelectCell.Image;// cho moi
			selectCell.Button.setIcon(user.SelectCell.Image);
			selectCell.Name = user.SelectCell.Name;

			user.SelectCell.Image = null; // cho cu
			user.SelectCell.Name = null;
			user.SelectCell.Button.setIcon(null);
			user.SelectCell.type = null;
			user.SelectCell = null;
			// selectCell.Name la o moi click.
			// user luu o click truoc do
			if (user.SelectCell.Name == "xe") {
				if (selectCell.x == user.SelectCell.x || selectCell.y == user.SelectCell.y) {// táº¥t
																								// cáº£
																								// cÃ¡c
																								// nÆ°á»›c
																								// Ä‘i
																								// cá»§a
																								// quÃ¢n
																								// xe
																								// Ä‘á»�u
																								// há»£p
																								// lá»‡
					if (selectCell.x > user.SelectCell.x) {// kiá»ƒm tra váº­t
															// cáº£n
						for (int i = user.SelectCell.x + 1; i < selectCell.x; i++) {
							final int temp = i;
							Cell cell = user.ListCells.stream()// cell lÃ  Ã´
																// á»Ÿ giá»¯a
									.filter(p -> p.x == temp && p.y == selectCell.y).findFirst().orElse(new Cell());

							if (cell.Name != null) { // náº¿u cÃ³ quÃ¢n cá»�
														// thÃ¬ khÃ´ng Ä‘Æ°á»£c
														// Ä‘i
								user.SelectCell = null;
								return;
							}

						}
					}
					if (selectCell.x < user.SelectCell.x) {// kiá»ƒm tra váº­t
															// cáº£n
						for (int i = selectCell.x + 1; i < user.SelectCell.x; i++) {
							final int temp = i;
							Cell cell = user.ListCells.stream()// cell lÃ  Ã´
																// á»Ÿ giá»¯a
									.filter(p -> p.x == temp && p.y == selectCell.y).findFirst().orElse(new Cell());

							if (cell.Name != null) { // náº¿u cÃ³ quÃ¢n cá»�
														// thÃ¬ khÃ´ng Ä‘Æ°á»£c
														// Ä‘i
								user.SelectCell = null;
								return;
							}

						}
					}
					if (selectCell.y > user.SelectCell.y) {// kiá»ƒm tra váº­t
															// cáº£n
						for (int i = user.SelectCell.y + 1; i < selectCell.y; i++) {
							final int temp = i;
							Cell cell = user.ListCells.stream()// cell lÃ  Ã´
																// á»Ÿ giá»¯a
									.filter(p -> p.y == temp && p.x == selectCell.x).findFirst().orElse(new Cell());

							if (cell.Name != null) { // náº¿u cÃ³ quÃ¢n cá»�
														// thÃ¬ khÃ´ng Ä‘Æ°á»£c
														// Ä‘i
								user.SelectCell = null;
								return;
							}

						}
					}

					if (selectCell.y < user.SelectCell.y) {// kiá»ƒm tra váº­t
															// cáº£n
						for (int i = selectCell.y + 1; i < user.SelectCell.y; i++) {
							final int temp = i;
							Cell cell = user.ListCells.stream()// cell lÃ  Ã´
																// á»Ÿ giá»¯a
									.filter(p -> p.y == temp && p.x == selectCell.x).findFirst().orElse(new Cell());

							if (cell.Name != null) { // náº¿u cÃ³ quÃ¢n cá»�
														// thÃ¬ khÃ´ng Ä‘Æ°á»£c
														// Ä‘i
								user.SelectCell = null;
								return;
							}

						}
					}

					if (user.SelectCell.type == selectCell.type)// náº¿u cÃ¹ng
																// quÃ¢n thÃ¬
																// khÃ´ng
																// Ä‘Æ°á»£c Äƒn
					{
						user.SelectCell = null;
						return;
					}
					if (user.SelectCell.type == "trang") {
						selectCell.type = "trang";
					} else {
						selectCell.type = "den";
					}
					selectCell.Image = user.SelectCell.Image;// cho moi
					selectCell.Button.setIcon(user.SelectCell.Image);
					selectCell.Name = user.SelectCell.Name;

					user.SelectCell.Image = null; // cho cu
					user.SelectCell.Name = null;
					user.SelectCell.Button.setIcon(null);
					user.SelectCell.type = null;
					user.SelectCell = null;
					return;

				}
				user.SelectCell = null;
				return;

			}
			if (user.SelectCell.Name == "ngua") {
				if (((selectCell.x == user.SelectCell.x - 2 || selectCell.x == user.SelectCell.x + 2)
						&& (selectCell.y == user.SelectCell.y + 1 || selectCell.y == user.SelectCell.y - 1))
						|| ((selectCell.x == user.SelectCell.x - 1 || selectCell.x == user.SelectCell.x + 1)
								&& (selectCell.y == user.SelectCell.y + 2 || selectCell.y == user.SelectCell.y - 2))) {

					if (user.SelectCell.type == selectCell.type)// náº¿u cÃ¹ng
																// quÃ¢n thÃ¬
																// khÃ´ng
																// Ä‘Æ°á»£c Äƒn
					{
						user.SelectCell = null;
						return;
					}
					if (user.SelectCell.type == "trang") {
						selectCell.type = "trang";
					} else {
						selectCell.type = "den";
					}

					selectCell.Image = user.SelectCell.Image;// cho moi
					selectCell.Button.setIcon(user.SelectCell.Image);
					selectCell.Name = user.SelectCell.Name;

					user.SelectCell.Image = null; // cho cu
					user.SelectCell.Name = null;
					user.SelectCell.Button.setIcon(null);
					user.SelectCell.type = null;
					user.SelectCell = null;
					return;
				}
				user.SelectCell = null;
				return;
			}

			if (user.SelectCell.Name == "chot") {
				if (user.SelectCell.type == "trang") {// náº¿u quÃ¢n Ä‘i lÃ 
														// chá»‘t tráº¯ng
					if (user.SelectCell.x == 6
							&& (selectCell.x == user.SelectCell.x - 1 || selectCell.x == user.SelectCell.x - 2)
							&& selectCell.y == user.SelectCell.y) {// Ä‘i
																	// lÆ°á»£t
																	// Ä‘áº§u
																	// tiÃªn

						for (int i = 5; i >= selectCell.x; i--) {// kiá»ƒm tra
																	// váº­t
																	// cáº£n
							final int temp = i;
							Cell cell = user.ListCells.stream()// cell lÃ  Ã´
																// á»Ÿ giá»¯a
									.filter(p -> p.x == temp && p.y == selectCell.y).findFirst().orElse(new Cell());

							if (cell.Name != null) { // náº¿u cÃ³ quÃ¢n cá»�
														// thÃ¬ khÃ´ng Ä‘Æ°á»£c
														// Ä‘i
								user.SelectCell = null;
								return;
							}
						}

						selectCell.Image = user.SelectCell.Image;// cho moi
						selectCell.Button.setIcon(user.SelectCell.Image);
						selectCell.Name = user.SelectCell.Name;
						selectCell.type = "trang";
						user.SelectCell.Image = null; // cho cu
						user.SelectCell.Name = null;
						user.SelectCell.Button.setIcon(null);
						user.SelectCell.type = null;
						user.SelectCell = null;
						return;
					}
					if ((selectCell.y == user.SelectCell.y + 1 || selectCell.y == user.SelectCell.y - 1)
							&& selectCell.x == user.SelectCell.x - 1) {// Äƒn
																		// quÃ¢n
						if (selectCell.type == "den") {
							selectCell.Image = user.SelectCell.Image;// cho moi
							selectCell.Button.setIcon(user.SelectCell.Image);
							selectCell.Name = user.SelectCell.Name;
							selectCell.type = "trang";
							user.SelectCell.Image = null; // cho cu
							user.SelectCell.Name = null;
							user.SelectCell.Button.setIcon(null);
							user.SelectCell.type = null;
							user.SelectCell = null;
							return;
						}
					}

					if (selectCell.y == user.SelectCell.y && selectCell.x == user.SelectCell.x - 1
							&& selectCell.Name == null) {// cÃ¡c nÆ°á»›c Ä‘i bth
						selectCell.Image = user.SelectCell.Image;// cho moi
						selectCell.Button.setIcon(user.SelectCell.Image);
						selectCell.Name = user.SelectCell.Name;
						selectCell.type = "trang";
						user.SelectCell.Image = null; // cho cu
						user.SelectCell.Name = null;
						user.SelectCell.Button.setIcon(null);
						user.SelectCell.type = null;
						user.SelectCell = null;
						return;
					}
					user.SelectCell = null;
					return;
				}
				if (user.SelectCell.type == "den") {// náº¿u quÃ¢n Ä‘i lÃ 
													// chá»‘t Ä‘en
					if (user.SelectCell.x == 1
							&& (selectCell.x == user.SelectCell.x + 1 || selectCell.x == user.SelectCell.x + 2)
							&& selectCell.y == user.SelectCell.y) {// Ä‘i
																	// lÆ°á»£t
																	// Ä‘áº§u
																	// tiÃªn

						for (int i = 2; i <= selectCell.x; i++) {// kiá»ƒm tra
																	// váº­t
																	// cáº£n
							final int temp = i;
							Cell cell = user.ListCells.stream()// cell lÃ  Ã´
																// á»Ÿ giá»¯a
									.filter(p -> p.x == temp && p.y == selectCell.y).findFirst().orElse(new Cell());

							if (cell.Name != null) { // náº¿u cÃ³ quÃ¢n cá»�
														// thÃ¬ khÃ´ng Ä‘Æ°á»£c
														// Ä‘i
								user.SelectCell = null;
								return;
							}
						}

						selectCell.Image = user.SelectCell.Image;// cho moi
						selectCell.Button.setIcon(user.SelectCell.Image);
						selectCell.Name = user.SelectCell.Name;
						selectCell.type = "den";
						user.SelectCell.Image = null; // cho cu
						user.SelectCell.Name = null;
						user.SelectCell.Button.setIcon(null);
						user.SelectCell.type = null;
						user.SelectCell = null;
						return;
					}
					if ((selectCell.y == user.SelectCell.y + 1 || selectCell.y == user.SelectCell.y - 1)
							&& selectCell.x == user.SelectCell.x + 1) {// Äƒn
																		// quÃ¢n
						if (selectCell.type == "trang") {
							selectCell.Image = user.SelectCell.Image;// cho moi
							selectCell.Button.setIcon(user.SelectCell.Image);
							selectCell.Name = user.SelectCell.Name;
							selectCell.type = "den";
							user.SelectCell.Image = null; // cho cu
							user.SelectCell.Name = null;
							user.SelectCell.Button.setIcon(null);
							user.SelectCell.type = null;
							user.SelectCell = null;
							return;
						}
					}

					if (selectCell.y == user.SelectCell.y && selectCell.x == user.SelectCell.x + 1
							&& selectCell.Name == null) {// cÃ¡c nÆ°á»›c Ä‘i bth
						selectCell.Image = user.SelectCell.Image;// cho moi
						selectCell.Button.setIcon(user.SelectCell.Image);
						selectCell.Name = user.SelectCell.Name;
						selectCell.type = "den";
						user.SelectCell.Image = null; // cho cu
						user.SelectCell.Name = null;
						user.SelectCell.Button.setIcon(null);
						user.SelectCell.type = null;
						user.SelectCell = null;
						return;
					}
					user.SelectCell = null;
					return;
				}
			}

			if (user.SelectCell.Name == "tuong") {
				if (selectCell.x - selectCell.y == user.SelectCell.x - user.SelectCell.y) {// kiá»ƒm
																							// tra
																							// Ä‘Æ°á»�ng
																							// chÃ©o
																							// trÃ¡i
					if (selectCell.x > user.SelectCell.x) {// kiá»ƒm tra váº­t
															// cáº£n
						for (int i = user.SelectCell.x + 1, j = user.SelectCell.y + 1; i < selectCell.x; i++, j++) {
							final int temp = i;
							final int temp2 = j;
							Cell cell = user.ListCells.stream()// cell lÃ  Ã´
																// á»Ÿ giá»¯a
									.filter(p -> p.x == temp && p.y == temp2).findFirst().orElse(new Cell());

							if (cell.Name != null) { // náº¿u cÃ³ quÃ¢n cá»�
														// thÃ¬ khÃ´ng Ä‘Æ°á»£c
														// Ä‘i
								user.SelectCell = null;
								return;
							}

						}
					}
					if (selectCell.x < user.SelectCell.x) {// kiá»ƒm tra váº­t
															// cáº£n
						for (int i = selectCell.x + 1, j = selectCell.y + 1; i < user.SelectCell.x; i++, j++) {
							final int temp = i;
							final int temp2 = j;
							Cell cell = user.ListCells.stream()// cell lÃ  Ã´
																// á»Ÿ giá»¯a
									.filter(p -> p.x == temp && p.y == temp2).findFirst().orElse(new Cell());

							if (cell.Name != null) { // náº¿u cÃ³ quÃ¢n cá»�
														// thÃ¬ khÃ´ng Ä‘Æ°á»£c
														// Ä‘i
								user.SelectCell = null;
								return;
							}

						}
					}

					if (user.SelectCell.type == selectCell.type)// náº¿u cÃ¹ng
																// quÃ¢n thÃ¬
																// khÃ´ng
																// Ä‘Æ°á»£c Äƒn
					{
						user.SelectCell = null;
						return;
					}
					if (user.SelectCell.type == "trang") {
						selectCell.type = "trang";
					} else {
						selectCell.type = "den";
					}

					selectCell.Image = user.SelectCell.Image;// cho moi
					selectCell.Button.setIcon(user.SelectCell.Image);
					selectCell.Name = user.SelectCell.Name;

					user.SelectCell.Image = null; // cho cu
					user.SelectCell.Name = null;
					user.SelectCell.Button.setIcon(null);
					user.SelectCell.type = null;
					user.SelectCell = null;
					return;

				}
				if (selectCell.x + selectCell.y == user.SelectCell.x + user.SelectCell.y) {// kiá»ƒm
																							// tra
																							// Ä‘Æ°á»�ng
																							// chÃ©o
																							// pháº£i
					if (selectCell.x > user.SelectCell.x) {
						for (int i = user.SelectCell.x + 1, j = user.SelectCell.y - 1; i < selectCell.x; i++, j--) {
							final int temp = i;
							final int temp2 = j;
							Cell cell = user.ListCells.stream()// cell lÃ  Ã´
																// á»Ÿ giá»¯a
									.filter(p -> p.x == temp && p.y == temp2).findFirst().orElse(new Cell());

							if (cell.Name != null) { // náº¿u cÃ³ quÃ¢n cá»�
														// thÃ¬ khÃ´ng Ä‘Æ°á»£c
														// Ä‘i
								user.SelectCell = null;
								return;
							}

						}
					}

					if (selectCell.x < user.SelectCell.x) {
						for (int i = user.SelectCell.x - 1, j = user.SelectCell.y + 1; j < selectCell.y; i--, j++) {
							final int temp = i;
							final int temp2 = j;
							Cell cell = user.ListCells.stream()// cell lÃ  Ã´
																// á»Ÿ giá»¯a
									.filter(p -> p.x == temp && p.y == temp2).findFirst().orElse(new Cell());

							if (cell.Name != null) { // náº¿u cÃ³ quÃ¢n cá»�
														// thÃ¬ khÃ´ng Ä‘Æ°á»£c
														// Ä‘i
								user.SelectCell = null;
								return;
							}

						}
					}

					if (user.SelectCell.type == selectCell.type)// náº¿u cÃ¹ng
																// quÃ¢n thÃ¬
																// khÃ´ng
																// Ä‘Æ°á»£c Äƒn
					{
						user.SelectCell = null;
						return;
					}
					if (user.SelectCell.type == "trang") {
						selectCell.type = "trang";
					} else {
						selectCell.type = "den";
					}

					selectCell.Image = user.SelectCell.Image;// cho moi
					selectCell.Button.setIcon(user.SelectCell.Image);
					selectCell.Name = user.SelectCell.Name;
					if (user.SelectCell.type == "trang") {
						selectCell.type = "trang";
					} else {
						selectCell.type = "den";
					}
					user.SelectCell.Image = null; // cho cu
					user.SelectCell.Name = null;
					user.SelectCell.Button.setIcon(null);
					user.SelectCell.type = null;
					user.SelectCell = null;
					return;
				}
				user.SelectCell = null;
				return;
			}

			if (user.SelectCell.Name == "hau") {
				if (selectCell.x - selectCell.y == user.SelectCell.x - user.SelectCell.y) {// kiá»ƒm
																							// tra
																							// Ä‘Æ°á»�ng
																							// chÃ©o
																							// trÃ¡i
					if (selectCell.x > user.SelectCell.x) {// kiá»ƒm tra váº­t
															// cáº£n
						for (int i = user.SelectCell.x + 1, j = user.SelectCell.y + 1; i < selectCell.x; i++, j++) {
							final int temp = i;
							final int temp2 = j;
							Cell cell = user.ListCells.stream()// cell lÃ  Ã´
																// á»Ÿ giá»¯a
									.filter(p -> p.x == temp && p.y == temp2).findFirst().orElse(new Cell());

							if (cell.Name != null) { // náº¿u cÃ³ quÃ¢n cá»�
														// thÃ¬ khÃ´ng Ä‘Æ°á»£c
														// Ä‘i
								user.SelectCell = null;
								return;
							}

						}
					}
					if (selectCell.x < user.SelectCell.x) {// kiá»ƒm tra váº­t
															// cáº£n
						for (int i = selectCell.x + 1, j = selectCell.y + 1; i < user.SelectCell.x; i++, j++) {
							final int temp = i;
							final int temp2 = j;
							Cell cell = user.ListCells.stream()// cell lÃ  Ã´
																// á»Ÿ giá»¯a
									.filter(p -> p.x == temp && p.y == temp2).findFirst().orElse(new Cell());

							if (cell.Name != null) { // náº¿u cÃ³ quÃ¢n cá»�
														// thÃ¬ khÃ´ng Ä‘Æ°á»£c
														// Ä‘i
								user.SelectCell = null;
								return;
							}

						}
					}

					if (user.SelectCell.type == selectCell.type)// náº¿u cÃ¹ng
																// quÃ¢n thÃ¬
																// khÃ´ng
																// Ä‘Æ°á»£c Äƒn
					{
						user.SelectCell = null;
						return;
					}
					if (user.SelectCell.type == "trang") {
						selectCell.type = "trang";
					} else {
						selectCell.type = "den";
					}

					selectCell.Image = user.SelectCell.Image;// cho moi
					selectCell.Button.setIcon(user.SelectCell.Image);
					selectCell.Name = user.SelectCell.Name;

					user.SelectCell.Image = null; // cho cu
					user.SelectCell.Name = null;
					user.SelectCell.Button.setIcon(null);
					user.SelectCell.type = null;
					user.SelectCell = null;
					return;

				}
				if (selectCell.x + selectCell.y == user.SelectCell.x + user.SelectCell.y) {// kiá»ƒm
																							// tra
																							// Ä‘Æ°á»�ng
																							// chÃ©o
																							// pháº£i
					if (selectCell.x > user.SelectCell.x) {
						for (int i = user.SelectCell.x + 1, j = user.SelectCell.y - 1; i < selectCell.x; i++, j--) {
							final int temp = i;
							final int temp2 = j;
							Cell cell = user.ListCells.stream()// cell lÃ  Ã´
																// á»Ÿ giá»¯a
									.filter(p -> p.x == temp && p.y == temp2).findFirst().orElse(new Cell());

							if (cell.Name != null) { // náº¿u cÃ³ quÃ¢n cá»�
														// thÃ¬ khÃ´ng Ä‘Æ°á»£c
														// Ä‘i
								user.SelectCell = null;
								return;
							}

						}
					}

					if (selectCell.x < user.SelectCell.x) {
						for (int i = user.SelectCell.x - 1, j = user.SelectCell.y + 1; j < selectCell.y; i--, j++) {
							final int temp = i;
							final int temp2 = j;
							Cell cell = user.ListCells.stream()// cell lÃ  Ã´
																// á»Ÿ giá»¯a
									.filter(p -> p.x == temp && p.y == temp2).findFirst().orElse(new Cell());

							if (cell.Name != null) { // náº¿u cÃ³ quÃ¢n cá»�
														// thÃ¬ khÃ´ng Ä‘Æ°á»£c
														// Ä‘i
								user.SelectCell = null;
								return;
							}

						}
					}

					if (user.SelectCell.type == selectCell.type)// náº¿u cÃ¹ng
																// quÃ¢n thÃ¬
																// khÃ´ng
																// Ä‘Æ°á»£c Äƒn
					{
						user.SelectCell = null;
						return;
					}
					if (user.SelectCell.type == "trang") {
						selectCell.type = "trang";
					} else {
						selectCell.type = "den";
					}

					selectCell.Image = user.SelectCell.Image;// cho moi
					selectCell.Button.setIcon(user.SelectCell.Image);
					selectCell.Name = user.SelectCell.Name;
					if (user.SelectCell.type == "trang") {
						selectCell.type = "trang";
					} else {
						selectCell.type = "den";
					}
					user.SelectCell.Image = null; // cho cu
					user.SelectCell.Name = null;
					user.SelectCell.Button.setIcon(null);
					user.SelectCell.type = null;
					user.SelectCell = null;
					return;
				}

				if (selectCell.x == user.SelectCell.x || selectCell.y == user.SelectCell.y) {// táº¥t
																								// cáº£
																								// cÃ¡c
																								// nÆ°á»›c
																								// Ä‘i
																								// cá»§a
																								// quÃ¢n
																								// xe
																								// Ä‘á»�u
																								// há»£p
																								// lá»‡
					if (selectCell.x > user.SelectCell.x) {// kiá»ƒm tra váº­t
															// cáº£n
						for (int i = user.SelectCell.x + 1; i < selectCell.x; i++) {
							final int temp = i;
							Cell cell = user.ListCells.stream()// cell lÃ  Ã´
																// á»Ÿ giá»¯a
									.filter(p -> p.x == temp && p.y == selectCell.y).findFirst().orElse(new Cell());

							if (cell.Name != null) { // náº¿u cÃ³ quÃ¢n cá»�
														// thÃ¬ khÃ´ng Ä‘Æ°á»£c
														// Ä‘i
								user.SelectCell = null;
								return;
							}

						}
					}
					if (selectCell.x < user.SelectCell.x) {// kiá»ƒm tra váº­t
															// cáº£n
						for (int i = selectCell.x + 1; i < user.SelectCell.x; i++) {
							final int temp = i;
							Cell cell = user.ListCells.stream()// cell lÃ  Ã´
																// á»Ÿ giá»¯a
									.filter(p -> p.x == temp && p.y == selectCell.y).findFirst().orElse(new Cell());

							if (cell.Name != null) { // náº¿u cÃ³ quÃ¢n cá»�
														// thÃ¬ khÃ´ng Ä‘Æ°á»£c
														// Ä‘i
								user.SelectCell = null;
								return;
							}

						}
					}
					if (selectCell.y > user.SelectCell.y) {// kiá»ƒm tra váº­t
															// cáº£n
						for (int i = user.SelectCell.y + 1; i < selectCell.y; i++) {
							final int temp = i;
							Cell cell = user.ListCells.stream()// cell lÃ  Ã´
																// á»Ÿ giá»¯a
									.filter(p -> p.y == temp && p.x == selectCell.x).findFirst().orElse(new Cell());

							if (cell.Name != null) { // náº¿u cÃ³ quÃ¢n cá»�
														// thÃ¬ khÃ´ng Ä‘Æ°á»£c
														// Ä‘i
								user.SelectCell = null;
								return;
							}

						}
					}

					if (selectCell.y < user.SelectCell.y) {// kiá»ƒm tra váº­t
															// cáº£n
						for (int i = selectCell.y + 1; i < user.SelectCell.y; i++) {
							final int temp = i;
							Cell cell = user.ListCells.stream()// cell lÃ  Ã´
																// á»Ÿ giá»¯a
									.filter(p -> p.y == temp && p.x == selectCell.x).findFirst().orElse(new Cell());

							if (cell.Name != null) { // náº¿u cÃ³ quÃ¢n cá»�
														// thÃ¬ khÃ´ng Ä‘Æ°á»£c
														// Ä‘i
								user.SelectCell = null;
								return;
							}

						}
					}

					if (user.SelectCell.type == selectCell.type)// náº¿u cÃ¹ng
																// quÃ¢n thÃ¬
																// khÃ´ng
																// Ä‘Æ°á»£c Äƒn
					{
						user.SelectCell = null;
						return;
					}
					if (user.SelectCell.type == "trang") {
						selectCell.type = "trang";
					} else {
						selectCell.type = "den";
					}
					selectCell.Image = user.SelectCell.Image;// cho moi
					selectCell.Button.setIcon(user.SelectCell.Image);
					selectCell.Name = user.SelectCell.Name;

					user.SelectCell.Image = null; // cho cu
					user.SelectCell.Name = null;
					user.SelectCell.Button.setIcon(null);
					user.SelectCell.type = null;
					user.SelectCell = null;
					return;
				}
				user.SelectCell = null;
				return;
			}

			if (user.SelectCell.Name == "vua") {
				if ((selectCell.x == user.SelectCell.x
						&& (selectCell.y == user.SelectCell.y + 1 || selectCell.y == user.SelectCell.y - 1))
						|| (selectCell.x == user.SelectCell.x + 1 && (selectCell.y == user.SelectCell.y + 1
								|| selectCell.y == user.SelectCell.y - 1 || selectCell.y == user.SelectCell.y))
						|| (selectCell.x == user.SelectCell.x - 1 && (selectCell.y == user.SelectCell.y + 1
								|| selectCell.y == user.SelectCell.y - 1 || selectCell.y == user.SelectCell.y))) {// táº¥t
																													// cáº£
																													// cÃ¡c
																													// nÆ°á»›c
																													// Ä‘i
																													// cá»§a
																													// quÃ¢n
																													// xe
																													// Ä‘á»�u
																													// há»£p
																													// lá»‡

					if (selectCell.type == user.SelectCell.type) { // náº¿u
																	// cÃ¹ng
																	// quÃ¢n
																	// thÃ¬
																	// khÃ´ng
																	// Ä‘Æ°á»£c
																	// Äƒn
						user.SelectCell = null;
						return;
					}

					// =====================================TUONG=======================================

					for (int i = selectCell.x + 1, j = selectCell.y + 1; i <= 7 && j <= 7; i++, j++) {// kiem
																										// tra
																										// cheo
																										// trai
						final int temp = i;
						final int temp2 = j;
						Cell cell = user.ListCells.stream()// cell lÃ  Ã´ á»Ÿ
															// giá»¯a
								.filter(p -> p.x == temp && p.y == temp2).findFirst().orElse(new Cell());
						if ((cell.Name == "tuong"
								|| (i == selectCell.x + 1 && (cell.Name == "chot" || cell.Name == "vua"))
								|| cell.Name == "hau") && cell.type != user.SelectCell.type) { // náº¿u
																								// gáº·p
																								// váº­t
																								// cáº£n
																								// Ä‘áº§u
																								// tiÃªn
																								// lÃ 
																								// tÆ°á»£ng
																								// thÃ¬
																								// k
																								// Ä‘Æ°á»£c
																								// Ä‘i
							user.SelectCell = null;
							return;
						}
						if (cell.Name != "tuong" && cell.Name != null && cell.Name != "hau") { // náº¿u
																								// gáº·p
																								// váº­t
																								// cáº£n
																								// Ä‘áº§u
																								// tiÃªn
																								// mÃ 
																								// k
																								// phai
																								// la
																								// tuong
																								// thÃ¬
																								// Ä‘Æ°á»£c
																								// Ä‘i
							break;
						}
					}
					for (int i = selectCell.x - 1, j = selectCell.y - 1; i >= 0 && j >= 0; i--, j--) {
						final int temp = i;
						final int temp2 = j;
						Cell cell = user.ListCells.stream()// cell lÃ  Ã´ á»Ÿ
															// giá»¯a
								.filter(p -> p.x == temp && p.y == temp2).findFirst().orElse(new Cell());

						if ((cell.Name == "tuong"
								|| (i == selectCell.x - 1 && (cell.Name == "chot" || cell.Name == "vua"))
								|| cell.Name == "hau") && cell.type != user.SelectCell.type) { // náº¿u
																								// gáº·p
																								// váº­t
																								// cáº£n
																								// Ä‘áº§u
																								// tiÃªn
																								// lÃ 
																								// tÆ°á»£ng
																								// thÃ¬
																								// k
																								// Ä‘Æ°á»£c
																								// Ä‘i
							user.SelectCell = null;
							return;
						}
						if (cell.Name != "tuong" && cell.Name != null && cell.Name != "hau") { // náº¿u
																								// gáº·p
																								// váº­t
																								// cáº£n
																								// Ä‘áº§u
																								// tiÃªn
																								// mÃ 
																								// k
																								// phai
																								// la
																								// tuong
																								// thÃ¬
																								// Ä‘Æ°á»£c
																								// Ä‘i
							break;
						}

					}

					for (int i = selectCell.x - 1, j = selectCell.y + 1; i >= 0 && j <= 7; i--, j++) { // kiá»ƒm
																										// tra
																										// chÃ©o
																										// pháº£i
						final int temp = i;
						final int temp2 = j;
						Cell cell = user.ListCells.stream()// cell lÃ  Ã´ á»Ÿ
															// giá»¯a
								.filter(p -> p.x == temp && p.y == temp2).findFirst().orElse(new Cell());

						if ((cell.Name == "tuong"
								|| (i == selectCell.x - 1 && (cell.Name == "chot" || cell.Name == "vua"))
								|| cell.Name == "hau") && cell.type != user.SelectCell.type) { // náº¿u
																								// gáº·p
																								// váº­t
																								// cáº£n
																								// Ä‘áº§u
																								// tiÃªn
																								// lÃ 
																								// tÆ°á»£ng
																								// thÃ¬
																								// k
																								// Ä‘Æ°á»£c
																								// Ä‘i
							user.SelectCell = null;
							return;
						}
						if (cell.Name != "tuong" && cell.Name != null && cell.Name != "hau") { // náº¿u
																								// gáº·p
																								// váº­t
																								// cáº£n
																								// Ä‘áº§u
																								// tiÃªn
																								// mÃ 
																								// k
																								// phai
																								// la
																								// tuong
																								// thÃ¬
																								// Ä‘Æ°á»£c
																								// Ä‘i
							break;
						}

					}

					for (int i = selectCell.x + 1, j = selectCell.y - 1; i <= 7 && j >= 0; i++, j--) { // kiá»ƒm
																										// tra
																										// chÃ©o
																										// pháº£i
						final int temp = i;
						final int temp2 = j;
						Cell cell = user.ListCells.stream()// cell lÃ  Ã´ á»Ÿ
															// giá»¯a
								.filter(p -> p.x == temp && p.y == temp2).findFirst().orElse(new Cell());

						if ((cell.Name == "tuong"
								|| (i == selectCell.x + 1 && (cell.Name == "chot" || cell.Name == "vua"))
								|| cell.Name == "hau") && cell.type != user.SelectCell.type) { // náº¿u
																								// gáº·p
																								// váº­t
																								// cáº£n
																								// Ä‘áº§u
																								// tiÃªn
																								// lÃ 
																								// tÆ°á»£ng
																								// thÃ¬
																								// k
																								// Ä‘Æ°á»£c
																								// Ä‘i
							user.SelectCell = null;
							return;
						}
						if (cell.Name != "tuong" && cell.Name != null && cell.Name != "hau") { // náº¿u
																								// gáº·p
																								// váº­t
																								// cáº£n
																								// Ä‘áº§u
																								// tiÃªn
																								// mÃ 
																								// k
																								// phai
																								// la
																								// tuong
																								// thÃ¬
																								// Ä‘Æ°á»£c
																								// Ä‘i
							break;
						}

					}
					// ============================END
					// TUONG===================================

					// ============================XE=================================
					for (int i = selectCell.x, j = selectCell.y + 1; j <= 7; j++) { // x
																					// giá»¯
																					// nguyÃªn
						final int temp = i;
						final int temp2 = j;
						Cell cell = user.ListCells.stream()// cell lÃ  Ã´ á»Ÿ
															// giá»¯a
								.filter(p -> p.x == temp && p.y == temp2).findFirst().orElse(new Cell());
						if ((cell.Name == "xe" || cell.Name == "hau" || (j == selectCell.y + 1 && cell.Name == "vua"))
								&& cell.type != user.SelectCell.type) {
							user.SelectCell = null;
							return;
						}
						if (cell.Name != "xe" && cell.Name != null && cell.Name != "hau") { // náº¿u
																							// gáº·p
																							// váº­t
																							// cáº£n
																							// Ä‘áº§u
																							// tiÃªn
																							// mÃ 
																							// k
																							// phai
																							// la
																							// tuong
																							// thÃ¬
																							// Ä‘Æ°á»£c
																							// Ä‘i
							break;
						}
					}
					for (int i = selectCell.x, j = selectCell.y - 1; j >= 0; j--) { // x
																					// giá»¯
																					// nguyÃªn
						final int temp = i;
						final int temp2 = j;
						Cell cell = user.ListCells.stream()// cell lÃ  Ã´ á»Ÿ
															// giá»¯a
								.filter(p -> p.x == temp && p.y == temp2).findFirst().orElse(new Cell());
						if ((cell.Name == "xe" || cell.Name == "hau" || (j == selectCell.y - 1 && cell.Name == "vua"))
								&& cell.type != user.SelectCell.type) {
							user.SelectCell = null;
							return;
						}
						if (cell.Name != "xe" && cell.Name != null && cell.Name != "hau") { // náº¿u
																							// gáº·p
																							// váº­t
																							// cáº£n
																							// Ä‘áº§u
																							// tiÃªn
																							// mÃ 
																							// k
																							// phai
																							// la
																							// tuong
																							// thÃ¬
																							// Ä‘Æ°á»£c
																							// Ä‘i
							break;
						}
					}

					for (int i = selectCell.x - 1, j = selectCell.y; i >= 0; i--) { // x
																					// giá»¯
																					// nguyÃªn
						final int temp = i;
						final int temp2 = j;
						Cell cell = user.ListCells.stream()// cell lÃ  Ã´ á»Ÿ
															// giá»¯a
								.filter(p -> p.x == temp && p.y == temp2).findFirst().orElse(new Cell());
						if ((cell.Name == "xe" || cell.Name == "hau" || (i == selectCell.x - 1 && cell.Name == "vua"))
								&& cell.type != user.SelectCell.type) {
							user.SelectCell = null;
							return;
						}
						if (cell.Name != "xe" && cell.Name != null && cell.Name != "hau") { // náº¿u
																							// gáº·p
																							// váº­t
																							// cáº£n
																							// Ä‘áº§u
																							// tiÃªn
																							// mÃ 
																							// k
																							// phai
																							// la
																							// tuong
																							// thÃ¬
																							// Ä‘Æ°á»£c
																							// Ä‘i
							break;
						}
					}

					for (int i = selectCell.x + 1, j = selectCell.y; i <= 7; i++) { // x
																					// giá»¯
																					// nguyÃªn
						final int temp = i;
						final int temp2 = j;
						Cell cell = user.ListCells.stream()// cell lÃ  Ã´ á»Ÿ
															// giá»¯a
								.filter(p -> p.x == temp && p.y == temp2).findFirst().orElse(new Cell());
						if ((cell.Name == "xe" || cell.Name == "hau" || (i == selectCell.x + 1 && cell.Name == "vua"))
								&& cell.type != user.SelectCell.type) {
							user.SelectCell = null;
							return;
						}
						if (cell.Name != "xe" && cell.Name != null && cell.Name != "hau") { // náº¿u
																							// gáº·p
																							// váº­t
																							// cáº£n
																							// Ä‘áº§u
																							// tiÃªn
																							// mÃ 
																							// k
																							// phai
																							// la
																							// tuong
																							// thÃ¬
																							// Ä‘Æ°á»£c
																							// Ä‘i
							break;
						}
					}

					// ============================END
					// XE=================================

					// ============================NGUA=================================
					for (int i = selectCell.x - 1, j = selectCell.y - 2; j <= selectCell.y + 2; i--, j++) {
						if (j == selectCell.y) {
							i = selectCell.x + 3;
							continue;
						}
						final int temp = i;
						final int temp2 = j;
						Cell cell = user.ListCells.stream()// cell lÃ  Ã´ á»Ÿ
															// giá»¯a
								.filter(p -> p.x == temp && p.y == temp2).findFirst().orElse(new Cell());
						if (cell.Name == "ngua" && cell.type != user.SelectCell.type) {
							user.SelectCell = null;
							return;
						}
					}

					for (int i = selectCell.x + 1, j = selectCell.y - 2; j <= selectCell.y + 2; i++, j++) {
						if (j == selectCell.y) {
							i = selectCell.x - 3;
							continue;
						}
						final int temp = i;
						final int temp2 = j;
						Cell cell = user.ListCells.stream()// cell lÃ  Ã´ á»Ÿ
															// giá»¯a
								.filter(p -> p.x == temp && p.y == temp2).findFirst().orElse(new Cell());
						if (cell.Name == "ngua" && cell.type != user.SelectCell.type) {
							user.SelectCell = null;
							return;
						}
					}

					// ============================END
					// NGUA=================================

					if (user.SelectCell.type == "trang") {
						selectCell.type = "trang";
					} else {
						selectCell.type = "den";
					}

					selectCell.Image = user.SelectCell.Image;// cho moi
					selectCell.Button.setIcon(user.SelectCell.Image);
					selectCell.Name = user.SelectCell.Name;

					user.SelectCell.Image = null; // cho cu
					user.SelectCell.Name = null;
					user.SelectCell.Button.setIcon(null);
					user.SelectCell.type = null;
					user.SelectCell = null;
					return;

					// }===========================================================

				}

			}

		}
	}
}