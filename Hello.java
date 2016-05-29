import java.util.Scanner;
public class Hello{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		System.out.println("欢迎来到扫雷游戏");
		int[][] bobs=null;
		boolean gameflag = true;
		int passcount = 0;
		while(gameflag){
			System.out.println("请选择游戏难度");
			System.out.println("1:简单");
			System.out.println("2:中等");
			System.out.println("3:困难");
			int userselect =s.nextInt();
			if(userselect<1|userselect>3){
				System.out.println("您选择有误");
				continue;
			}
			switch(userselect){
			case 1:bobs = new int[3][3];break;
			case 2:bobs = new int[6][6];break;
			case 3:bobs = new int[9][9];break;
			}
			for(int i=0;i<bobs.length;i++){
				System.out.println();
				for(int j=0;j<bobs[i].length;j++){
					int random =(int)((Math.random()*10)/5);
					if(random==0){
						passcount++;
					}
					System.out.print(random+" ");
					bobs[i][j]=random;
				}
			}
			boolean playflag = true;
			int gamepasscount = 0;
			while(playflag){
				System.out.println("请输入行号");
				int row = s.nextInt();
				if(row<=0||row>bobs.length){
					System.out.println("您输入行号有误");
					continue;
				}
				boolean colflag = true;
				//gamepasscount不能放在这里，否则每次否会被置零
				int col = 0;
				while(colflag){
					System.out.println("请输入列号");
					col = s.nextInt();
					if(col<=bobs[row-1].length&&col>0){
						break;
					}
					else{
						System.out.println("您输入列号有误");
					}
				}//输入列号判断结束
				if(bobs[row-1][col-1]==2){
					System.out.println("此区域已被选择过");
					continue;
				}
				if(bobs[row-1][col-1]==0){
					gamepasscount++;
					bobs[row-1][col-1]=2;
					if(gamepasscount==passcount){
						System.out.println("恭喜您玩通关了");
						break;	
					}
					System.out.println("PASS");
				}else{
					System.out.println("您死掉了");
					break;
				}
			}//玩游戏的循环结束
			System.out.println("按1继续非1退出");
			int userinput = s.nextInt();
			if(userinput!=1){
				break;
			}

		}

	}

}