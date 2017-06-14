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
                                        final int temp = i;
                                        Cell cell = user.ListCells.stream()// cell là ô ở giữa 
                                        .filter(p -> p.x == temp && p.y == selectCell.y)
                                        .findFirst()
                                        .orElse(new Cell());
                                        
                                        if(cell.Name != null){  //nếu có quân cờ thì không được đi
                                            user.SelectCell = null;
                                            return;
                                        }  
                                        
                                    }
                                }
                                if(selectCell.x < user.SelectCell.x){// kiểm tra vật cản
                                    for(int i = selectCell.x + 1; i < user.SelectCell.x; i++){
                                        final int temp = i;
                                        Cell cell = user.ListCells.stream()// cell là ô ở giữa 
                                        .filter(p -> p.x == temp && p.y == selectCell.y)
                                        .findFirst()
                                        .orElse(new Cell());
                                        
                                        if(cell.Name != null){  //nếu có quân cờ thì không được đi
                                            user.SelectCell = null;
                                            return;
                                        }  
                                        
                                    }
                                }
                                if(selectCell.y > user.SelectCell.y){// kiểm tra vật cản
                                    for(int i = user.SelectCell.y + 1; i < selectCell.y; i++){
                                        final int temp = i;
                                        Cell cell = user.ListCells.stream()// cell là ô ở giữa 
                                        .filter(p -> p.y == temp && p.x == selectCell.x)
                                        .findFirst()
                                        .orElse(new Cell());
                                        
                                        if(cell.Name != null){  //nếu có quân cờ thì không được đi
                                            user.SelectCell = null;
                                            return;
                                        }  
                                        
                                    }
                                }
                                
                                if(selectCell.y < user.SelectCell.y){// kiểm tra vật cản
                                    for(int i = selectCell.y + 1; i < user.SelectCell.y; i++){
                                        final int temp = i;
                                        Cell cell = user.ListCells.stream()// cell là ô ở giữa 
                                        .filter(p -> p.y == temp && p.x == selectCell.x)
                                        .findFirst()
                                        .orElse(new Cell());
                                        
                                        if(cell.Name != null){  //nếu có quân cờ thì không được đi
                                            user.SelectCell = null;
                                            return;
                                        }  
                                        
                                    }
                                }
                
                               if(user.SelectCell.type == selectCell.type )// nếu cùng quân thì không được ăn
                               {
                                   user.SelectCell = null;
                                   return;
                               }
                               if(user.SelectCell.type=="trang"){
                                   selectCell.type="trang";
                               }
                               else{
                                   selectCell.type="den";
                               }
                                selectCell.Image = user.SelectCell.Image;// cho moi
                                selectCell.Button.setIcon(user.SelectCell.Image);
                                selectCell.Name = user.SelectCell.Name;
                                
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
                            if(((selectCell.x == user.SelectCell.x -2 || selectCell.x == user.SelectCell.x + 2) && 
                                    (selectCell.y == user.SelectCell.y + 1 || selectCell.y == user.SelectCell.y - 1))||
                                    ((selectCell.x == user.SelectCell.x -1 || selectCell.x == user.SelectCell.x + 1) && 
                                    (selectCell.y == user.SelectCell.y + 2 || selectCell.y == user.SelectCell.y - 2))
                                    ){
                                
                               if(user.SelectCell.type == selectCell.type )// nếu cùng quân thì không được ăn
                               {
                                   user.SelectCell = null;
                                   return;
                               }
                               if(user.SelectCell.type=="trang"){
                                   selectCell.type="trang";
                               }
                               else{
                                   selectCell.type="den";
                               }
                               
                                selectCell.Image = user.SelectCell.Image;// cho moi
                                selectCell.Button.setIcon(user.SelectCell.Image);
                                selectCell.Name = user.SelectCell.Name;
                               
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
                        
                        if(user.SelectCell.Name == "chot"){
                            if(user.SelectCell.type == "trang"){// nếu quân đi là chốt trắng
                                if(user.SelectCell.x==6 &&(selectCell.x ==user.SelectCell.x - 1 ||
                                        selectCell.x == user.SelectCell.x -2)&& selectCell.y==user.SelectCell.y){//đi lượt đầu tiên
                                    
                                     for(int i = 5; i >=selectCell.x; i-- ){// kiểm tra vật cản
                                          final int temp = i;
                                            Cell cell = user.ListCells.stream()// cell là ô ở giữa 
                                            .filter(p -> p.x == temp && p.y == selectCell.y)
                                            .findFirst()
                                            .orElse(new Cell());

                                            if(cell.Name != null){  //nếu có quân cờ thì không được đi
                                                user.SelectCell = null;
                                                return;
                                            }  
                                     }  
                                    
                                    
                                    
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
                                if((selectCell.y == user.SelectCell.y+1 || selectCell.y == user.SelectCell.y-1) && selectCell.x ==user.SelectCell.x - 1 ){// ăn quân
                                    if(selectCell.type == "den") {
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
                                }
                                
                               if(selectCell.y == user.SelectCell.y && selectCell.x ==user.SelectCell.x - 1 && selectCell.Name==null){// các nước đi bth
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
                                if(user.SelectCell.type == "den"){// nếu quân đi là chốt đen
                                if(user.SelectCell.x==1 &&(selectCell.x ==user.SelectCell.x + 1 ||
                                        selectCell.x == user.SelectCell.x +2)&& selectCell.y==user.SelectCell.y){//đi lượt đầu tiên
                                    
                                     for(int i = 2; i <=selectCell.x; i++ ){// kiểm tra vật cản
                                          final int temp = i;
                                            Cell cell = user.ListCells.stream()// cell là ô ở giữa 
                                            .filter(p -> p.x == temp && p.y == selectCell.y)
                                            .findFirst()
                                            .orElse(new Cell());

                                            if(cell.Name != null){  //nếu có quân cờ thì không được đi
                                                user.SelectCell = null;
                                                return;
                                            }  
                                     }  
                                    
                                    
                                    
                                    selectCell.Image = user.SelectCell.Image;// cho moi
                                    selectCell.Button.setIcon(user.SelectCell.Image);
                                    selectCell.Name = user.SelectCell.Name;
                                    selectCell.type = "den";
                                    user.SelectCell.Image = null;   // cho cu
                                    user.SelectCell.Name = null;
                                    user.SelectCell.Button.setIcon(null);
                                    user.SelectCell.type=null;
                                    user.SelectCell = null;
                                    return;
                                }
                                if((selectCell.y == user.SelectCell.y+1 || selectCell.y == user.SelectCell.y-1) && selectCell.x ==user.SelectCell.x + 1 ){// ăn quân
                                    if(selectCell.type == "trang") {
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
                                }
                                
                               if(selectCell.y == user.SelectCell.y && selectCell.x ==user.SelectCell.x + 1 && selectCell.Name==null){// các nước đi bth
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
                               if(selectCell.x > user.SelectCell.x){// kiểm tra vật cản
                                    for(int i = user.SelectCell.x + 1, j = user.SelectCell.y+1; i < selectCell.x; i++, j++){
                                        final int temp = i;
                                        final int temp2 = j;
                                        Cell cell = user.ListCells.stream()// cell là ô ở giữa 
                                        .filter(p -> p.x == temp && p.y == temp2)
                                        .findFirst()
                                        .orElse(new Cell());
                                        
                                        if(cell.Name != null){  //nếu có quân cờ thì không được đi
                                            user.SelectCell = null;
                                            return;
                                        }  
                                        
                                    }
                                }
                                if(selectCell.x < user.SelectCell.x){// kiểm tra vật cản
                                    for(int i = selectCell.x + 1, j = selectCell.y + 1; i < user.SelectCell.x; i++, j++){
                                        final int temp = i;
                                        final int temp2 = j;
                                        Cell cell = user.ListCells.stream()// cell là ô ở giữa 
                                        .filter(p -> p.x == temp && p.y == temp2)
                                        .findFirst()
                                        .orElse(new Cell());
                                        
                                        if(cell.Name != null){  //nếu có quân cờ thì không được đi
                                            user.SelectCell = null;
                                            return;
                                        }  
                                        
                                    }
                                }

                                if(user.SelectCell.type == selectCell.type )// nếu cùng quân thì không được ăn
                               {
                                   user.SelectCell = null;
                                   return;
                               }
                               if(user.SelectCell.type=="trang"){
                                   selectCell.type="trang";
                               }
                               else{
                                   selectCell.type="den";
                               }
                                
                                
                                selectCell.Image = user.SelectCell.Image;// cho moi
                                selectCell.Button.setIcon(user.SelectCell.Image);
                                selectCell.Name = user.SelectCell.Name;     
                              
                                user.SelectCell.Image = null;   // cho cu
                                user.SelectCell.Name = null;
                                user.SelectCell.Button.setIcon(null);
                                user.SelectCell.type=null;
                                user.SelectCell = null;
                                return;
                            
                            }
                            if(selectCell.x + selectCell.y == user.SelectCell.x + user.SelectCell.y){// kiểm tra đường chéo phải
                                if(selectCell.x > user.SelectCell.x){
                                    for(int i = user.SelectCell.x + 1, j = user.SelectCell.y-1; i < selectCell.x; i++, j--){
                                        final int temp = i;
                                        final int temp2 = j;
                                        Cell cell = user.ListCells.stream()// cell là ô ở giữa 
                                        .filter(p -> p.x == temp && p.y == temp2)
                                        .findFirst()
                                        .orElse(new Cell());
                                        
                                        if(cell.Name != null){  //nếu có quân cờ thì không được đi
                                            user.SelectCell = null;
                                            return;
                                        }  
                                        
                                    }
                                }
                                
                                if(selectCell.x < user.SelectCell.x){
                                    for(int i = user.SelectCell.x -1 , j = user.SelectCell.y+1; j < selectCell.y; i--, j++){
                                        final int temp = i;
                                        final int temp2 = j;
                                        Cell cell = user.ListCells.stream()// cell là ô ở giữa 
                                        .filter(p -> p.x == temp && p.y == temp2)
                                        .findFirst()
                                        .orElse(new Cell());
                                        
                                        if(cell.Name != null){  //nếu có quân cờ thì không được đi
                                            user.SelectCell = null;
                                            return;
                                        }  
                                        
                                    }
                                }
                                
                                 if(user.SelectCell.type == selectCell.type )// nếu cùng quân thì không được ăn
                               {
                                   user.SelectCell = null;
                                   return;
                               }
                               if(user.SelectCell.type=="trang"){
                                   selectCell.type="trang";
                               }
                               else{
                                   selectCell.type="den";
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
                          
                        if(user.SelectCell.Name == "hau"){
                            if(selectCell.x - selectCell.y == user.SelectCell.x - user.SelectCell.y){// kiểm tra đường chéo trái
                                           if(selectCell.x > user.SelectCell.x){// kiểm tra vật cản
                                    for(int i = user.SelectCell.x + 1, j = user.SelectCell.y+1; i < selectCell.x; i++, j++){
                                        final int temp = i;
                                        final int temp2 = j;
                                        Cell cell = user.ListCells.stream()// cell là ô ở giữa 
                                        .filter(p -> p.x == temp && p.y == temp2)
                                        .findFirst()
                                        .orElse(new Cell());
                                        
                                        if(cell.Name != null){  //nếu có quân cờ thì không được đi
                                            user.SelectCell = null;
                                            return;
                                        }  
                                        
                                    }
                                }
                                if(selectCell.x < user.SelectCell.x){// kiểm tra vật cản
                                    for(int i = selectCell.x + 1, j = selectCell.y + 1; i < user.SelectCell.x; i++, j++){
                                        final int temp = i;
                                        final int temp2 = j;
                                        Cell cell = user.ListCells.stream()// cell là ô ở giữa 
                                        .filter(p -> p.x == temp && p.y == temp2)
                                        .findFirst()
                                        .orElse(new Cell());
                                        
                                        if(cell.Name != null){  //nếu có quân cờ thì không được đi
                                            user.SelectCell = null;
                                            return;
                                        }  
                                        
                                    }
                                }

                                if(user.SelectCell.type==selectCell.type )// nếu cùng quân thì không được ăn
                               {
                                   user.SelectCell = null;
                                   return;
                               }
                               if(user.SelectCell.type=="trang"){
                                   selectCell.type="trang";
                               }
                               else{
                                   selectCell.type="den";
                               }
                                
                                
                                selectCell.Image = user.SelectCell.Image;// cho moi
                                selectCell.Button.setIcon(user.SelectCell.Image);
                                selectCell.Name = user.SelectCell.Name;     
                              
                                user.SelectCell.Image = null;   // cho cu
                                user.SelectCell.Name = null;
                                user.SelectCell.Button.setIcon(null);
                                user.SelectCell.type=null;
                                user.SelectCell = null;
                                return;
                            
                            }
                            if(selectCell.x + selectCell.y == user.SelectCell.x + user.SelectCell.y){// kiểm tra đường chéo phải
                                         if(selectCell.x > user.SelectCell.x){
                                    for(int i = user.SelectCell.x + 1, j = user.SelectCell.y-1; i < selectCell.x; i++, j--){
                                        final int temp = i;
                                        final int temp2 = j;
                                        Cell cell = user.ListCells.stream()// cell là ô ở giữa 
                                        .filter(p -> p.x == temp && p.y == temp2)
                                        .findFirst()
                                        .orElse(new Cell());
                                        
                                        if(cell.Name != null){  //nếu có quân cờ thì không được đi
                                            user.SelectCell = null;
                                            return;
                                        }  
                                        
                                    }
                                }
                                
                                if(selectCell.x < user.SelectCell.x){
                                    for(int i = user.SelectCell.x -1 , j = user.SelectCell.y+1; j < selectCell.y; i--, j++){
                                        final int temp = i;
                                        final int temp2 = j;
                                        Cell cell = user.ListCells.stream()// cell là ô ở giữa 
                                        .filter(p -> p.x == temp && p.y == temp2)
                                        .findFirst()
                                        .orElse(new Cell());
                                        
                                        if(cell.Name != null){  //nếu có quân cờ thì không được đi
                                            user.SelectCell = null;
                                            return;
                                        }  
                                        
                                    }
                                }
                                
                               if(user.SelectCell.type == selectCell.type )// nếu cùng quân thì không được ăn
                               {
                                   user.SelectCell = null;
                                   return;
                               }
                               if(user.SelectCell.type=="trang"){
                                   selectCell.type="trang";
                               }
                               else{
                                   selectCell.type="den";
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
                            
                            if(selectCell.x == user.SelectCell.x || selectCell.y == user.SelectCell.y){// tất cả các nước đi của quân xe đều hợp lệ
                                       if(selectCell.x > user.SelectCell.x){// kiểm tra vật cản
                                    for(int i = user.SelectCell.x + 1; i < selectCell.x; i++){
                                        final int temp = i;
                                        Cell cell = user.ListCells.stream()// cell là ô ở giữa 
                                        .filter(p -> p.x == temp && p.y == selectCell.y)
                                        .findFirst()
                                        .orElse(new Cell());
                                        
                                        if(cell.Name != null){  //nếu có quân cờ thì không được đi
                                            user.SelectCell = null;
                                            return;
                                        }  
                                        
                                    }
                                }
                                if(selectCell.x < user.SelectCell.x){// kiểm tra vật cản
                                    for(int i = selectCell.x + 1; i < user.SelectCell.x; i++){
                                        final int temp = i;
                                        Cell cell = user.ListCells.stream()// cell là ô ở giữa 
                                        .filter(p -> p.x == temp && p.y == selectCell.y)
                                        .findFirst()
                                        .orElse(new Cell());
                                        
                                        if(cell.Name != null){  //nếu có quân cờ thì không được đi
                                            user.SelectCell = null;
                                            return;
                                        }  
                                        
                                    }
                                }
                                if(selectCell.y > user.SelectCell.y){// kiểm tra vật cản
                                    for(int i = user.SelectCell.y + 1; i < selectCell.y; i++){
                                        final int temp = i;
                                        Cell cell = user.ListCells.stream()// cell là ô ở giữa 
                                        .filter(p -> p.y == temp && p.x == selectCell.x)
                                        .findFirst()
                                        .orElse(new Cell());
                                        
                                        if(cell.Name != null){  //nếu có quân cờ thì không được đi
                                            user.SelectCell = null;
                                            return;
                                        }  
                                        
                                    }
                                }
                                
                                if(selectCell.y < user.SelectCell.y){// kiểm tra vật cản
                                    for(int i = selectCell.y + 1; i < user.SelectCell.y; i++){
                                        final int temp = i;
                                        Cell cell = user.ListCells.stream()// cell là ô ở giữa 
                                        .filter(p -> p.y == temp && p.x == selectCell.x)
                                        .findFirst()
                                        .orElse(new Cell());
                                        
                                        if(cell.Name != null){  //nếu có quân cờ thì không được đi
                                            user.SelectCell = null;
                                            return;
                                        }  
                                        
                                    }
                                }
                
                               if(user.SelectCell.type == selectCell.type )// nếu cùng quân thì không được ăn
                               {
                                   user.SelectCell = null;
                                   return;
                               }
                               if(user.SelectCell.type=="trang"){
                                   selectCell.type="trang";
                               }
                               else{
                                   selectCell.type="den";
                               }
                                selectCell.Image = user.SelectCell.Image;// cho moi
                                selectCell.Button.setIcon(user.SelectCell.Image);
                                selectCell.Name = user.SelectCell.Name;
                                
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
                                 ||(selectCell.x == user.SelectCell.x -1 && (selectCell.y==user.SelectCell.y + 1 || selectCell.y == user.SelectCell.y -1 || selectCell.y == user.SelectCell.y))){// tất cả các nước đi của quân xe đều hợp lệ
                                
                                if(selectCell.type == user.SelectCell.type){    // nếu cùng quân thì không được ăn
                                    user.SelectCell=null;
                                    return;
                                }
                                
                               //   =====================================TUONG=======================================
                              
                                    for(int i = selectCell.x+1, j = selectCell.y+1; i <=7 && j<=7; i++, j++){// kiem tra cheo trai
                                        final int temp = i;
                                        final int temp2 = j;
                                        Cell cell = user.ListCells.stream()// cell là ô ở giữa 
                                        .filter(p -> p.x == temp && p.y == temp2)
                                        .findFirst()
                                        .orElse(new Cell());
                                        if((cell.Name =="tuong" ||(i == selectCell.x+1 && (cell.Name=="chot" || cell.Name=="vua")) ||cell.Name=="hau")&& cell.type!=user.SelectCell.type ){ // nếu gặp vật cản đầu tiên là tượng thì k được đi
                                            user.SelectCell=null;
                                            return;
                                        }
                                        if(cell.Name !="tuong" && cell.Name!=null && cell.Name!="hau"){  //nếu gặp vật cản đầu tiên mà k phai la tuong thì được đi
                                            break;
                                        }       
                                    }
                                    for(int i = selectCell.x-1, j = selectCell.y-1; i>=0 &&j>=0; i--, j--){
                                        final int temp = i;
                                        final int temp2 = j;
                                        Cell cell = user.ListCells.stream()// cell là ô ở giữa 
                                        .filter(p -> p.x == temp && p.y == temp2)
                                        .findFirst()
                                        .orElse(new Cell());
                                        
                                        if((cell.Name =="tuong" ||(i == selectCell.x-1 && (cell.Name=="chot"||cell.Name=="vua"))||cell.Name=="hau")&& cell.type!=user.SelectCell.type){ // nếu gặp vật cản đầu tiên là tượng thì k được đi
                                            user.SelectCell=null;
                                            return;
                                        }
                                        if(cell.Name !="tuong" && cell.Name!=null && cell.Name!="hau"){  //nếu gặp vật cản đầu tiên mà k phai la tuong thì được đi
                                            break;
                                        }     
                                        
                                    }
                                    
                                    for(int i = selectCell.x-1, j = selectCell.y+1; i>=0 &&j<=7; i--, j++){ // kiểm tra chéo phải 
                                        final int temp = i;
                                        final int temp2 = j;
                                        Cell cell = user.ListCells.stream()// cell là ô ở giữa 
                                        .filter(p -> p.x == temp && p.y == temp2)
                                        .findFirst()
                                        .orElse(new Cell());
                                        
                                        if((cell.Name =="tuong" ||(i == selectCell.x-1 && (cell.Name=="chot" || cell.Name=="vua"))||cell.Name=="hau")&& cell.type!=user.SelectCell.type){ // nếu gặp vật cản đầu tiên là tượng thì k được đi
                                            user.SelectCell=null;
                                            return;
                                        }
                                        if(cell.Name !="tuong" && cell.Name!=null&& cell.Name!="hau"){  //nếu gặp vật cản đầu tiên mà k phai la tuong thì được đi
                                            break;
                                        }     
                                        
                                    }
                                    
                                     for(int i = selectCell.x+1, j = selectCell.y-1; i<=7 &&j>=0; i++, j--){ // kiểm tra chéo phải 
                                        final int temp = i;
                                        final int temp2 = j;
                                        Cell cell = user.ListCells.stream()// cell là ô ở giữa 
                                        .filter(p -> p.x == temp && p.y == temp2)
                                        .findFirst()
                                        .orElse(new Cell());
                                        
                                        if((cell.Name =="tuong" ||(i == selectCell.x+1 && (cell.Name=="chot" || cell.Name=="vua"))||cell.Name=="hau")&& cell.type!=user.SelectCell.type){ // nếu gặp vật cản đầu tiên là tượng thì k được đi
                                            user.SelectCell=null;
                                            return;
                                        }
                                        if(cell.Name !="tuong" && cell.Name!=null&& cell.Name!="hau"){  //nếu gặp vật cản đầu tiên mà k phai la tuong thì được đi
                                            break;
                                        }     
                                        
                                    }
                                    //============================END TUONG===================================
                                    
                                    //============================XE=================================
                                    for(int i = selectCell.x, j = selectCell.y+1; j <=7 ;  j++) {  // x giữ nguyên
                                        final int temp = i;
                                        final int temp2 = j;
                                        Cell cell = user.ListCells.stream()// cell là ô ở giữa 
                                        .filter(p -> p.x == temp && p.y == temp2)
                                        .findFirst()
                                        .orElse(new Cell());
                                        if((cell.Name=="xe" || cell.Name =="hau" || (j==selectCell.y+1 && cell.Name=="vua")) && cell.type!=user.SelectCell.type){
                                            user.SelectCell=null;
                                            return;
                                        }
                                        if(cell.Name !="xe" && cell.Name!=null&& cell.Name!="hau"){  //nếu gặp vật cản đầu tiên mà k phai la tuong thì được đi
                                            break;
                                        }         
                                    }
                                    for(int i = selectCell.x, j = selectCell.y-1; j >= 0;  j--) {  // x giữ nguyên
                                        final int temp = i;
                                        final int temp2 = j;
                                        Cell cell = user.ListCells.stream()// cell là ô ở giữa 
                                        .filter(p -> p.x == temp && p.y == temp2)
                                        .findFirst()
                                        .orElse(new Cell());
                                        if((cell.Name=="xe" || cell.Name =="hau" || (j==selectCell.y-1 && cell.Name=="vua")) && cell.type!=user.SelectCell.type){
                                            user.SelectCell=null;
                                            return;
                                        }
                                        if(cell.Name !="xe" && cell.Name!=null&& cell.Name!="hau"){  //nếu gặp vật cản đầu tiên mà k phai la tuong thì được đi
                                            break;
                                        }         
                                    }
                                    
                                    for(int i = selectCell.x-1, j = selectCell.y; i >=0 ;  i--) {  // x giữ nguyên
                                        final int temp = i;
                                        final int temp2 = j;
                                        Cell cell = user.ListCells.stream()// cell là ô ở giữa 
                                        .filter(p -> p.x == temp && p.y == temp2)
                                        .findFirst()
                                        .orElse(new Cell());
                                        if((cell.Name=="xe" || cell.Name =="hau" || (i==selectCell.x-1 && cell.Name=="vua")) && cell.type!=user.SelectCell.type){
                                            user.SelectCell=null;
                                            return;
                                        }
                                        if(cell.Name !="xe" && cell.Name!=null&& cell.Name!="hau"){  //nếu gặp vật cản đầu tiên mà k phai la tuong thì được đi
                                            break;
                                        }         
                                    }
                                    
                                    for(int i = selectCell.x+1, j = selectCell.y; i <=7 ;  i++) {  // x giữ nguyên
                                        final int temp = i;
                                        final int temp2 = j;
                                        Cell cell = user.ListCells.stream()// cell là ô ở giữa 
                                        .filter(p -> p.x == temp && p.y == temp2)
                                        .findFirst()
                                        .orElse(new Cell());
                                        if((cell.Name=="xe" || cell.Name =="hau" || (i==selectCell.x+1 && cell.Name=="vua")) && cell.type!=user.SelectCell.type){
                                            user.SelectCell=null;
                                            return;
                                        }
                                        if(cell.Name !="xe" && cell.Name!=null&& cell.Name!="hau"){  //nếu gặp vật cản đầu tiên mà k phai la tuong thì được đi
                                            break;
                                        }         
                                    }        
                                    
                                    //============================END XE=================================
                                    
                                    
                                    //============================NGUA=================================
                                   for(int i = selectCell.x-1, j = selectCell.y-2; j <= selectCell.y+2;i--, j++){
                                       if(j== selectCell.y ){
                                          i=selectCell.x+3;
                                           continue;
                                       }
                                        final int temp = i;
                                        final int temp2 = j;
                                        Cell cell = user.ListCells.stream()// cell là ô ở giữa 
                                        .filter(p -> p.x == temp && p.y == temp2)
                                        .findFirst()
                                        .orElse(new Cell());
                                        if(cell.Name=="ngua" && cell.type!=user.SelectCell.type){
                                            user.SelectCell=null;
                                            return;
                                        }
                                   }
                                    
                                    for(int i = selectCell.x+1, j = selectCell.y-2; j <= selectCell.y+2;i++, j++){
                                       if(j== selectCell.y ){
                                          i=selectCell.x-3;
                                           continue;
                                       }
                                        final int temp = i;
                                        final int temp2 = j;
                                        Cell cell = user.ListCells.stream()// cell là ô ở giữa 
                                        .filter(p -> p.x == temp && p.y == temp2)
                                        .findFirst()
                                        .orElse(new Cell());
                                        if(cell.Name=="ngua" && cell.type!=user.SelectCell.type){
                                            user.SelectCell=null;
                                            return;
                                        }
                                   }
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    //============================END NGUA=================================
                                    
                                    
                                    
                               if(user.SelectCell.type=="trang"){
                                   selectCell.type="trang";
                               }
                               else{
                                   selectCell.type="den";
                               }
                                
                                
                                selectCell.Image = user.SelectCell.Image;// cho moi
                                selectCell.Button.setIcon(user.SelectCell.Image);
                                selectCell.Name = user.SelectCell.Name;     
                              
                                user.SelectCell.Image = null;   // cho cu
                                user.SelectCell.Name = null;
                                user.SelectCell.Button.setIcon(null);
                                user.SelectCell.type=null;
                                user.SelectCell = null;
                                return;
                            
                            //}===========================================================
                            
                        }
                        
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