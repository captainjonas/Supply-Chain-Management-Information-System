package Model;


import java.util.ArrayList;

import Model.Pomain;

public class Page1 {
		private int nowpage;//��ǰ��ҳ��
		private int allpage;//��ҳ��
		private int  pagefen;//�趨ÿҳ��ʾ���������ݣ�
		private ArrayList<Pomain> pageyu;//ÿ�β�ѯ��������
		public int getNowpage() {
			return nowpage;
		}
		public void setNowpage(int nowpage) {
			this.nowpage = nowpage;
		}
		public int getAllpage() {
			return allpage;
		}
		public void setAllpage(int allpage) {
			this.allpage = allpage;
		}
		public int getPagefen() {
			return pagefen;
		}
		public void setPagefen(int pagefen) {
			this.pagefen = pagefen;
		}
		public ArrayList<Pomain> getPageyu() {
			return pageyu;
		}
		public void setPageyu(ArrayList<Pomain> pageyu) {
			this.pageyu = pageyu;
		}
		
	}

