import java.util.Scanner;
public class Hello{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		System.out.println("��ӭ����ɨ����Ϸ");
		int[][] bobs=null;
		boolean gameflag = true;
		int passcount = 0;
		while(gameflag){
			System.out.println("��ѡ����Ϸ�Ѷ�");
			System.out.println("1:��");
			System.out.println("2:�е�");
			System.out.println("3:����");
			int userselect =s.nextInt();
			if(userselect<1|userselect>3){
				System.out.println("��ѡ������");
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
				System.out.println("�������к�");
				int row = s.nextInt();
				if(row<=0||row>bobs.length){
					System.out.println("�������к�����");
					continue;
				}
				boolean colflag = true;
				//gamepasscount���ܷ����������ÿ�η�ᱻ����
				int col = 0;
				while(colflag){
					System.out.println("�������к�");
					col = s.nextInt();
					if(col<=bobs[row-1].length&&col>0){
						break;
					}
					else{
						System.out.println("�������к�����");
					}
				}//�����к��жϽ���
				if(bobs[row-1][col-1]==2){
					System.out.println("�������ѱ�ѡ���");
					continue;
				}
				if(bobs[row-1][col-1]==0){
					gamepasscount++;
					bobs[row-1][col-1]=2;
					if(gamepasscount==passcount){
						System.out.println("��ϲ����ͨ����");
						break;	
					}
					System.out.println("PASS");
				}else{
					System.out.println("��������");
					break;
				}
			}//����Ϸ��ѭ������
			System.out.println("��1������1�˳�");
			int userinput = s.nextInt();
			if(userinput!=1){
				break;
			}

		}

	}

}