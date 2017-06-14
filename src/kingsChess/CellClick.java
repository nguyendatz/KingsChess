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
		
		Cell selectCell = user.ListCells.stream()
	    		.filter(p -> p.Id.toString().equals(chessId))
	    		.findFirst()
	    		.orElse(new Cell());
//		Cell cell = user.ListCells.stream()
//                        .filter(p -> p.x == i && p->p.y == selectCell.y)
//                        .findFirst()
//                        .orElse(new Cell());
		if(user.SelectCell == null) // chua click lan nao
		{
			if(selectCell.Name == null) return;
			
                      //  selectCell.Button.setBackground(Color.decode("#0066ff"));
                        user.SelectCell = selectCell;
		}
                
		else    // click lan 2
		{
                        // selectCell.Name la o moi click.
                        // user luu o click truoc do
                        if(user.SelectCell.Name == "xe"){
                            if(selectCell.x == user.SelectCell.x || selectCell.y == user.SelectCell.y){// tất cả các nước đi của quân xe đều hợp lệ
                                if(selectCell.x > user.SelectCell.x){// kiểm tra vật cản
                                    for(int i = user.SelectCell.x + 1; i < selectCell.x; i++){
                                        Cell cell123 = user.ListCells.stream()
                                        .filter(p -> p.x == i && p.y == selectCell.y)
                                        .findFirst()
                                        .orElse(new Cell());
                                    }
                                }
                                
                                
                                
                                selectCell.Image = user.SelectCell.Image;// cho moi
                                selectCell.Button.setIcon(user.SelectCell.Image);
                                selectCell.Name = user.SelectCell.Name;
                                
                               if(user.SelectCell.type=="trang")
                               {
                                   selectCell.type="trang";
                               }
                               else{
                                   selectCell.type="den";
                               }
                                user.SelectCell.Image = null;   // cho cu
                                user.SelectCell.Name = null;
                                user.SelectCell.Button.setIcon(null);
                                user.SelectCell.type=null;
                                user.SelectCell = null;
                                return;
                            
                            }
                            user.SelectCell = null;
                            return;
                            
                        }
                        if(user.SelectCell.Name == "ngua"){
                            if((selectCell.x == user.SelectCell.x -2 || selectCell.x == user.SelectCell.x + 2) && 
                                    (selectCell.y == user.SelectCell.y + 1 || selectCell.y == user.SelectCell.y - 1)||
                                    (selectCell.x == user.SelectCell.x -1 || selectCell.x == user.SelectCell.x + 1) && 
                                    (selectCell.y == user.SelectCell.y + 2 || selectCell.y == user.SelectCell.y - 2)
                                    ){
                                selectCell.Image = user.SelectCell.Image;// cho moi
                                selectCell.Button.setIcon(user.SelectCell.Image);
                                selectCell.Name = user.SelectCell.Name;
                                if(user.SelectCell.type=="trang")
                               {
                                   selectCell.type="trang";
                               }
                               else{
                                   selectCell.type="den";
                               }
                                user.SelectCell.Image = null;   // cho cu
                                user.SelectCell.Name = null;
                                user.SelectCell.Button.setIcon(null);
                                user.SelectCell = null;
                                return;
                            }
                            user.SelectCell = null;
                            return;
                        }
                        
                        if(user.SelectCell.Name == "chot"){
                            if(user.SelectCell.type == "trang"){// nếu quân đi là chốt trắng
                                if(user.SelectCell.x==6 &&(selectCell.x ==user.SelectCell.x - 1 ||
                                        selectCell.x == user.SelectCell.x -2)){//đi lượt đầu tiên
                                    selectCell.Image = user.SelectCell.Image;// cho moi
                                    selectCell.Button.setIcon(user.SelectCell.Image);
                                    selectCell.Name = user.SelectCell.Name;
                                    selectCell.type = "trang";
                                    user.SelectCell.Image = null;   // cho cu
                                    user.SelectCell.Name = null;
                                    user.SelectCell.Button.setIcon(null);
                                    user.SelectCell.type=null;
                                    user.SelectCell = null;
                                    return;
                                }
                                if(user.SelectCell.x !=6 && selectCell.x ==user.SelectCell.x - 1 ){// khong phai nuoc di dau tien
                                    selectCell.Image = user.SelectCell.Image;// cho moi
                                    selectCell.Button.setIcon(user.SelectCell.Image);
                                    selectCell.Name = user.SelectCell.Name;
                                    selectCell.type="trang";
                                    user.SelectCell.Image = null;   // cho cu
                                    user.SelectCell.Name = null;
                                    user.SelectCell.Button.setIcon(null);
                                    user.SelectCell.type=null;
                                    user.SelectCell = null;
                                    return;
                                }
                                user.SelectCell = null;
                                return;
                            }
                            if(user.SelectCell.type == "den"){
                                if(user.SelectCell.x == 1 &&( selectCell.x ==user.SelectCell.x + 1 || // quân đen đi lượt đầu tiên
                                        selectCell.x == user.SelectCell.x +2)){
                                    selectCell.Image = user.SelectCell.Image;// cho moi
                                    selectCell.Button.setIcon(user.SelectCell.Image);
                                    selectCell.Name = user.SelectCell.Name;
                                    selectCell.type="den";
                                    user.SelectCell.Image = null;   // cho cu
                                    user.SelectCell.Name = null;
                                    user.SelectCell.Button.setIcon(null);
                                    user.SelectCell.type=null;
                                    user.SelectCell = null;
                                    return;
                                }
                                if(user.SelectCell.x !=1 && selectCell.x ==user.SelectCell.x + 1 ){// khong phai nuoc di dau tien
                                    selectCell.Image = user.SelectCell.Image;// cho moi
                                    selectCell.Button.setIcon(user.SelectCell.Image);
                                    selectCell.Name = user.SelectCell.Name;
                                    selectCell.type="den";
                                    user.SelectCell.Image = null;   // cho cu
                                    user.SelectCell.Name = null;
                                    user.SelectCell.Button.setIcon(null);
                                    user.SelectCell.type=null;
                                    user.SelectCell = null;
                                    return;
                                }
                                user.SelectCell = null;
                                return;
                            }                               
                        }
                        
                          if(user.SelectCell.Name == "tuong"){
                            if(selectCell.x - selectCell.y == user.SelectCell.x - user.SelectCell.y){// kiểm tra đường chéo trái
                                selectCell.Image = user.SelectCell.Image;// cho moi
                                selectCell.Button.setIcon(user.SelectCell.Image);
                                selectCell.Name = user.SelectCell.Name;
                               if(user.SelectCell.type=="trang")
                               {
                                   selectCell.type="trang";
                               }
                               else{
                                   selectCell.type="den";
                               }
                                user.SelectCell.Image = null;   // cho cu
                                user.SelectCell.Name = null;
                                user.SelectCell.Button.setIcon(null);
                                user.SelectCell.type=null;
                                user.SelectCell = null;
                                return;
                            
                            }
                            if(selectCell.x + selectCell.y == user.SelectCell.x + user.SelectCell.y){// kiểm tra đường chéo phải
                                 selectCell.Image = user.SelectCell.Image;// cho moi
                                selectCell.Button.setIcon(user.SelectCell.Image);
                                selectCell.Name = user.SelectCell.Name;
                               if(user.SelectCell.type=="trang")
                               {
                                   selectCell.type="trang";
                               }
                               else{
                                   selectCell.type="den";
                               }
                                user.SelectCell.Image = null;   // cho cu
                                user.SelectCell.Name = null;
                                user.SelectCell.Button.setIcon(null);
                                user.SelectCell.type=null;
                                user.SelectCell = null;
                                return;
                            }
                            user.SelectCell = null;   
                            return;
                        }
                          
                        if(user.SelectCell.Name == "hau"){
                            if(selectCell.x - selectCell.y == user.SelectCell.x - user.SelectCell.y){// kiểm tra đường chéo trái
                                selectCell.Image = user.SelectCell.Image;// cho moi
                                selectCell.Button.setIcon(user.SelectCell.Image);
                                selectCell.Name = user.SelectCell.Name;
                               if(user.SelectCell.type=="trang")
                               {
                                   selectCell.type="trang";
                               }
                               else{
                                   selectCell.type="den";
                               }
                                user.SelectCell.Image = null;   // cho cu
                                user.SelectCell.Name = null;
                                user.SelectCell.Button.setIcon(null);
                                user.SelectCell.type=null;
                                user.SelectCell = null;
                                return;
                            
                            }
                            if(selectCell.x + selectCell.y == user.SelectCell.x + user.SelectCell.y){// kiểm tra đường chéo phải
                                 selectCell.Image = user.SelectCell.Image;// cho moi
                                selectCell.Button.setIcon(user.SelectCell.Image);
                                selectCell.Name = user.SelectCell.Name;
                               if(user.SelectCell.type=="trang")
                               {
                                   selectCell.type="trang";
                               }
                               else{
                                   selectCell.type="den";
                               }
                                user.SelectCell.Image = null;   // cho cu
                                user.SelectCell.Name = null;
                                user.SelectCell.Button.setIcon(null);
                                user.SelectCell.type=null;
                                user.SelectCell = null;
                                return;
                            }
                            
                            if(selectCell.x == user.SelectCell.x || selectCell.y == user.SelectCell.y){// tất cả các nước đi của quân xe đều hợp lệ
                                selectCell.Image = user.SelectCell.Image;// cho moi
                                selectCell.Button.setIcon(user.SelectCell.Image);
                                selectCell.Name = user.SelectCell.Name;
                               if(user.SelectCell.type=="trang")
                               {
                                   selectCell.type="trang";
                               }
                               else{
                                   selectCell.type="den";
                               }
                                user.SelectCell.Image = null;   // cho cu
                                user.SelectCell.Name = null;
                                user.SelectCell.Button.setIcon(null);
                                user.SelectCell.type=null;
                                user.SelectCell = null;
                                return;
                            
                            }                            
                            user.SelectCell = null;    
                            return;
                        }
                        
                        if(user.SelectCell.Name == "vua"){
                            if((selectCell.x == user.SelectCell.x && (selectCell.y==user.SelectCell.y + 1 || selectCell.y == user.SelectCell.y -1))
                                 ||(selectCell.x == user.SelectCell.x + 1 && (selectCell.y==user.SelectCell.y + 1 || selectCell.y == user.SelectCell.y -1 || selectCell.y == user.SelectCell.y))   
                                 ||(selectCell.x == user.SelectCell.x -1 && (selectCell.y==user.SelectCell.y + 1 || selectCell.y == user.SelectCell.y -1 || selectCell.y == user.SelectCell.y))   
                                    
                                    
                                    ){// tất cả các nước đi của quân xe đều hợp lệ
                                selectCell.Image = user.SelectCell.Image;// cho moi
                                selectCell.Button.setIcon(user.SelectCell.Image);
                                selectCell.Name = user.SelectCell.Name;
                               if(user.SelectCell.type=="trang")
                               {
                                   selectCell.type="trang";
                               }
                               else{
                                   selectCell.type="den";
                               }
                                user.SelectCell.Image = null;   // cho cu
                                user.SelectCell.Name = null;
                                user.SelectCell.Button.setIcon(null);
                                user.SelectCell.type=null;
                                user.SelectCell = null;
                                return;
                            
                            }
                            user.SelectCell = null;
                            return;
                            
                        }
                        
                        
                        
                        
                        
                        
                        
                        
//			if(selectCell.Name != null){
//                            user.SelectCell = null;
//                            return; // có quân cờ khác
//                        }
                        //
                        
//			selectCell.Image = user.SelectCell.Image;// cho moi
//			selectCell.Button.setIcon(user.SelectCell.Image);
//			selectCell.Name = user.SelectCell.Name;
//			
//			user.SelectCell.Image = null;   // cho cu
//			user.SelectCell.Name = null;
//			user.SelectCell.Button.setIcon(null);
//					
//			user.SelectCell = null;
                        
                        //
		}
	}
}