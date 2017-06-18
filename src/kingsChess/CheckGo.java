package kingsChess;

public class CheckGo {
    boolean canGo(User user, Cell selectCell){
        
        if (user.SelectCell.Name.equals("xe")) {
				if (selectCell.x == user.SelectCell.x || selectCell.y == user.SelectCell.y) {// táº¥t
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
								return false;
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
								return false;
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
								return false;
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
								return false;
							}

						}
					}

					if (user.SelectCell.type.equals(selectCell.type))// náº¿u cÃ¹ng														// Ä‘Æ°á»£c Äƒn
					{
						user.SelectCell = null;
						return false;
					}
					return true;

				}
				user.SelectCell = null;
				return false;

			}
        	if (user.SelectCell.Name.equals("ngua")) {
				if (((selectCell.x == user.SelectCell.x - 2 || selectCell.x == user.SelectCell.x + 2)
						&& (selectCell.y == user.SelectCell.y + 1 || selectCell.y == user.SelectCell.y - 1))
						|| ((selectCell.x == user.SelectCell.x - 1 || selectCell.x == user.SelectCell.x + 1)
								&& (selectCell.y == user.SelectCell.y + 2 || selectCell.y == user.SelectCell.y - 2))) {

					if (user.SelectCell.type.equals(selectCell.type))// náº¿u cÃ¹ng
					{
						user.SelectCell = null;
						return false;
					}
					return true;
				}
				user.SelectCell = null;
				return false;
			}
        
        	if (user.SelectCell.Name.equals("chot")) {
				if (user.SelectCell.type.equals("trang")) {// náº¿u quÃ¢n Ä‘i lÃ 
														// chá»‘t tráº¯ng
					if (user.SelectCell.x == 6
							&& (selectCell.x == user.SelectCell.x - 1 || selectCell.x == user.SelectCell.x - 2)
							&& selectCell.y == user.SelectCell.y) {// Ä‘i
																	// lÆ°á»£t
																	// Ä‘áº§u
																	// tiÃªn

						for (int i = 5; i >= selectCell.x; i--) {// kiá»ƒm tra
							final int temp = i;
							Cell cell = user.ListCells.stream()// cell lÃ  Ã´
																// á»Ÿ giá»¯a
									.filter(p -> p.x == temp && p.y == selectCell.y).findFirst().orElse(new Cell());

							if (cell.Name != null) { // náº¿u cÃ³ quÃ¢n cá»�
								return false;
							}
						}
                                               
						return true;
					}
					if ((selectCell.y == user.SelectCell.y + 1 || selectCell.y == user.SelectCell.y - 1)
							&& selectCell.x == user.SelectCell.x - 1) {// Äƒn
																		// quÃ¢n
						if ("den".equals(selectCell.type)) {
                                                      
							return true;
						}
					}

					if (selectCell.y == user.SelectCell.y && selectCell.x == user.SelectCell.x - 1
							&& selectCell.Name == null) {// cÃ¡c nÆ°á»›c Ä‘i bth
						return true;
					}
					user.SelectCell = null;
					return false;
				}
				if (user.SelectCell.type.equals("den")) {// náº¿u quÃ¢n Ä‘i lÃ 
													// chá»‘t Ä‘en
					if (user.SelectCell.x == 1
							&& (selectCell.x == user.SelectCell.x + 1 || selectCell.x == user.SelectCell.x + 2)
							&& selectCell.y == user.SelectCell.y) {// Ä‘i
						for (int i = 2; i <= selectCell.x; i++) {// kiá»ƒm tra
									// cáº£n
							final int temp = i;
							Cell cell = user.ListCells.stream()// cell lÃ  Ã´
																// á»Ÿ giá»¯a
									.filter(p -> p.x == temp && p.y == selectCell.y).findFirst().orElse(new Cell());

							if (cell.Name != null) { // náº¿u cÃ³ quÃ¢n cá»�
								user.SelectCell = null;
								return false;
							}
						}
						return true;
					}
					if ((selectCell.y == user.SelectCell.y + 1 || selectCell.y == user.SelectCell.y - 1)
							&& selectCell.x == user.SelectCell.x + 1) {// Äƒn
																		// quÃ¢n
						if ("trang".equals(selectCell.type)) {
							return true;
						}
					}

					if (selectCell.y == user.SelectCell.y && selectCell.x == user.SelectCell.x + 1
							&& selectCell.Name == null) {// cÃ¡c nÆ°á»›c Ä‘i bth
						return true;
					}
					user.SelectCell = null;
					return false;
				}
			}
        
        	if (user.SelectCell.Name.equals("hau")) {
				if (selectCell.x - selectCell.y == user.SelectCell.x - user.SelectCell.y) {// kiá»ƒm															// trÃ¡i
					if (selectCell.x > user.SelectCell.x) {// kiá»ƒm tra váº­t
															// cáº£n
						for (int i = user.SelectCell.x + 1, j = user.SelectCell.y + 1; i < selectCell.x; i++, j++) {
							final int temp = i;
							final int temp2 = j;
							Cell cell = user.ListCells.stream()// cell lÃ  Ã´
																// á»Ÿ giá»¯a
									.filter(p -> p.x == temp && p.y == temp2).findFirst().orElse(new Cell());

							if (cell.Name != null) { // náº¿u cÃ³ quÃ¢n cá»�
								user.SelectCell = null;
								return false;
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
								user.SelectCell = null;
								return false;
							}

						}
					}

					if (user.SelectCell.type.equals(selectCell.type))// náº¿u cÃ¹ng									// Ä‘Æ°á»£c Äƒn
					{
						user.SelectCell = null;
						return false;
					}
					return true;

				}
				if (selectCell.x + selectCell.y == user.SelectCell.x + user.SelectCell.y) {// kiá»ƒm																	// pháº£i
					if (selectCell.x > user.SelectCell.x) {
						for (int i = user.SelectCell.x + 1, j = user.SelectCell.y - 1; i < selectCell.x; i++, j--) {
							final int temp = i;
							final int temp2 = j;
							Cell cell = user.ListCells.stream()// cell lÃ  Ã´
																// á»Ÿ giá»¯a
									.filter(p -> p.x == temp && p.y == temp2).findFirst().orElse(new Cell());

							if (cell.Name != null) { // náº¿u cÃ³ quÃ¢n cá»�
								user.SelectCell = null;
								return false;
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
								user.SelectCell = null;
								return false;
							}

						}
					}

					if (user.SelectCell.type.equals(selectCell.type))// náº¿u cÃ¹ng											// khÃ´ng															// Ä‘Æ°á»£c Äƒn
					{
						user.SelectCell = null;
						return false;
					}
					return true;
				}

				if (selectCell.x == user.SelectCell.x || selectCell.y == user.SelectCell.y) {// táº¥t																// há»£p
																								// lá»‡
					if (selectCell.x > user.SelectCell.x) {// kiá»ƒm tra váº­t
															// cáº£n
						for (int i = user.SelectCell.x + 1; i < selectCell.x; i++) {
							final int temp = i;
							Cell cell = user.ListCells.stream()// cell lÃ  Ã´
																// á»Ÿ giá»¯a
									.filter(p -> p.x == temp && p.y == selectCell.y).findFirst().orElse(new Cell());

							if (cell.Name != null) { // náº¿u cÃ³ quÃ¢n cá»�
								user.SelectCell = null;
								return false;
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
								user.SelectCell = null;
								return false;
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
								user.SelectCell = null;
								return false;
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
								user.SelectCell = null;
								return false;
							}

						}
					}

					if (user.SelectCell.type.equals(selectCell.type))// náº¿u cÃ¹ng										// Ä‘Æ°á»£c Äƒn
					{
						user.SelectCell = null;
						return false;
					}
					return true; 
				}
				user.SelectCell = null;
				return false;
			}
        
        	if (user.SelectCell.Name.equals("tuong")) {
				if (selectCell.x - selectCell.y == user.SelectCell.x - user.SelectCell.y) {// kiá»ƒm
							// trÃ¡i
					if (selectCell.x > user.SelectCell.x) {// kiá»ƒm tra váº­t
															// cáº£n
						for (int i = user.SelectCell.x + 1, j = user.SelectCell.y + 1; i < selectCell.x; i++, j++) {
							final int temp = i;
							final int temp2 = j;
							Cell cell = user.ListCells.stream()// cell lÃ  Ã´
																// á»Ÿ giá»¯a
									.filter(p -> p.x == temp && p.y == temp2).findFirst().orElse(new Cell());

							if (cell.Name != null) { // náº¿u cÃ³ quÃ¢n cá»�						// Ä‘i
								user.SelectCell = null;
								return false;
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

							if (cell.Name != null) { // náº¿u cÃ³ quÃ¢n cá»�						// Ä‘i
								user.SelectCell = null;
								return false;
							}

						}
					}

					if (user.SelectCell.type.equals(selectCell.type))// náº¿u cÃ¹ng									// Ä‘Æ°á»£c Äƒn
					{
						user.SelectCell = null;
						return false;
					}
					return true;

				}
				if (selectCell.x + selectCell.y == user.SelectCell.x + user.SelectCell.y) {// kiá»ƒm																// pháº£i
					if (selectCell.x > user.SelectCell.x) {
						for (int i = user.SelectCell.x + 1, j = user.SelectCell.y - 1; i < selectCell.x; i++, j--) {
							final int temp = i;
							final int temp2 = j;
							Cell cell = user.ListCells.stream()// cell lÃ  Ã´
																// á»Ÿ giá»¯a
									.filter(p -> p.x == temp && p.y == temp2).findFirst().orElse(new Cell());

							if (cell.Name != null) { // náº¿u cÃ³ quÃ¢n cá»�					// Ä‘i
								user.SelectCell = null;
								return false;
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

							if (cell.Name != null) { // náº¿u cÃ³ quÃ¢n cá»�						// Ä‘i
								user.SelectCell = null;
								return false;
							}

						}
					}

					if (user.SelectCell.type.equals(selectCell.type))// náº¿u cÃ¹ng										// khÃ´ng
																// Ä‘Æ°á»£c Äƒn
					{
						user.SelectCell = null;
						return false;
					}	
					return true;
				}
				user.SelectCell = null;
				return false;
			}
        
        if (user.SelectCell.Name.equals("vua")) {
				if ((selectCell.x == user.SelectCell.x
						&& (selectCell.y == user.SelectCell.y + 1 || selectCell.y == user.SelectCell.y - 1))
						|| (selectCell.x == user.SelectCell.x + 1 && (selectCell.y == user.SelectCell.y + 1
								|| selectCell.y == user.SelectCell.y - 1 || selectCell.y == user.SelectCell.y))
						|| (selectCell.x == user.SelectCell.x - 1 && (selectCell.y == user.SelectCell.y + 1
								|| selectCell.y == user.SelectCell.y - 1 || selectCell.y == user.SelectCell.y))) {// táº¥t
					if (user.SelectCell.type.equals(selectCell.type)) { // náº¿u											// Äƒn
						user.SelectCell = null;
						return false;
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
						if (("tuong".equals(cell.Name)
								|| (i == selectCell.x + 1 && ("chot".equals(cell.Name) || "vua".equals(cell.Name)))
								|| "hau".equals(cell.Name)) && user.SelectCell.type.equals(cell.type)==false) { // náº¿u															// Ä‘i
							user.SelectCell = null;
							return false;
						}
						if ("tuong".equals(cell.Name)==false && cell.Name != null && "hau".equals(cell.Name)==false) { // náº¿u																// Ä‘i
							break;
						}
					}
					for (int i = selectCell.x - 1, j = selectCell.y - 1; i >= 0 && j >= 0; i--, j--) {
						final int temp = i;
						final int temp2 = j;
						Cell cell = user.ListCells.stream()// cell lÃ  Ã´ á»Ÿ
															// giá»¯a
								.filter(p -> p.x == temp && p.y == temp2).findFirst().orElse(new Cell());

						if (("tuong".equals(cell.Name)
								|| (i == selectCell.x - 1 && ("chot".equals(cell.Name) || "vua".equals(cell.Name)))
								|| "hau".equals(cell.Name)) && user.SelectCell.type.equals(cell.type)==false) { // náº¿u																	// Ä‘i
							user.SelectCell = null;
							return false;
						}
						if ("tuong".equals(cell.Name)==false && cell.Name != null && "hau".equals(cell.Name)==false){ // náº¿u																	// Ä‘Æ°á»£c					// Ä‘i
							break;
						}

					}

					for (int i = selectCell.x - 1, j = selectCell.y + 1; i >= 0 && j <= 7; i--, j++) { // kiá»ƒm																		// pháº£i
						final int temp = i;
						final int temp2 = j;
						Cell cell = user.ListCells.stream()// cell lÃ  Ã´ á»Ÿ
															// giá»¯a
								.filter(p -> p.x == temp && p.y == temp2).findFirst().orElse(new Cell());

						if (("tuong".equals(cell.Name)
								|| (i == selectCell.x - 1 && ("chot".equals(cell.Name) || "vua".equals(cell.Name)))
								|| "hau".equals(cell.Name)) && user.SelectCell.type.equals(cell.type)==false) { // náº¿u													// Ä‘i
							user.SelectCell = null;
							return false;
						}
						if ("tuong".equals(cell.Name)==false && cell.Name != null && "hau".equals(cell.Name)==false) { // náº¿u												// Ä‘i
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

						if (("tuong".equals(cell.Name)
								|| (i == selectCell.x + 1 && ("chot".equals(cell.Name) || "vua".equals(cell.Name)))
								|| "hau".equals(cell.Name)) && user.SelectCell.type.equals(cell.type)==false) { // náº¿u												// Ä‘i
							user.SelectCell = null;
							return false;
						}
						if ("tuong".equals(cell.Name)==false && cell.Name != null && "hau".equals(cell.Name)==false) { // náº¿u																// Ä‘i
							break;
						}

					}
					// ============================ENDTUONG===================================

					// ============================XE=================================
					for (int i = selectCell.x, j = selectCell.y + 1; j <= 7; j++) { // x
																					// giá»¯
																					// nguyÃªn
						final int temp = i;
						final int temp2 = j;
						Cell cell = user.ListCells.stream()// cell lÃ  Ã´ á»Ÿ
															// giá»¯a
								.filter(p -> p.x == temp && p.y == temp2).findFirst().orElse(new Cell());
						if (("xe".equals(cell.Name) || "hau".equals(cell.Name) || (j == selectCell.y + 1 && "vua".equals(cell.Name)))
								&& user.SelectCell.type.equals(cell.type)==false) {
                                                        user.SelectCell = null;
							return false;
						}
						if ("xe".equals(cell.Name)==false && cell.Name != null && "hau".equals(cell.Name)==false) { // náº¿u											// Ä‘i
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
						if (("xe".equals(cell.Name) || "hau".equals(cell.Name) || (j == selectCell.y - 1 && "vua".equals(cell.Name)))
								&& user.SelectCell.type.equals(cell.type)==false) {
							user.SelectCell = null;
							return false;
						}
						if ("xe".equals(cell.Name)==false && cell.Name != null && "hau".equals(cell.Name)==false) { // náº¿u
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
						if (("xe".equals(cell.Name) || "hau".equals(cell.Name) || (i == selectCell.x - 1 && "vua".equals(cell.Name)))
								&& user.SelectCell.type.equals(cell.type)==false) {
							user.SelectCell = null;
							return false;
						}
						if ("xe".equals(cell.Name)==false && cell.Name != null && "hau".equals(cell.Name)==false){ // náº¿u											// Ä‘i
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
						if (("xe".equals(cell.Name) || "hau".equals(cell.Name) || (i == selectCell.x + 1 && "vua".equals(cell.Name)))
								&& user.SelectCell.type.equals(cell.type)==false) {
							user.SelectCell = null;
							return false;
						}
						if ("xe".equals(cell.Name)==false && cell.Name != null && "hau".equals(cell.Name)==false){ // náº¿u													// Ä‘i
							break;
						}
					}

					// ============================ENDXE=================================

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
						if ("ngua".equals(cell.Name) && user.SelectCell.type.equals(cell.type)==false) {
							user.SelectCell = null;
							return false;
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
						if ("ngua".equals(cell.Name) && user.SelectCell.type.equals(cell.type)==false) {
							user.SelectCell = null;
							return false;
						}
					}

					// ============================END NGUA=================================

                                    return true;

					// }===========================================================

				}

			}
                
                
                
        
        
        return false;
    }
}
