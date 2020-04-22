/*
 * Mainwindow.java
 *
 * Created on __DATE__, __TIME__
 */

package com.ddb.windowMain;

import javax.swing.JOptionPane;

import com.ddb.model.*;
import com.ddb.steiner.BuildTree;
import com.ddb.steiner.FindBase;

import java.awt.Color;
import java.awt.Graphics;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * 
 * @author __USER__
 */

public class Mainwindow extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	/**
	 * Creates new form Mainwindow
	 * 
	 * @throws SQLException
	 */
	public Mainwindow(){
		initComponents();
		initMine();
	
	}


	private void initMine() {
		
		graphicInfo = new HashMap<String, Graphic>();
		DijInfo = new HashMap<String, DijGraphic>();
		kwNode = new ArrayList<String>();
		allNode = new ArrayList<String>();
		kwnode_kw = new HashMap<String, ArrayList<String>>();
		flag = new HashMap<String, AccessFlag>();
		root = new ArrayList<String>();
		root_kw = new HashMap<String, ArrayList<String>>();
		rootTrace = new HashMap<String, ArrayList<String>>();
		keyword = new ArrayList<String>(); // �����û�����Ĳ�ѯ�ؼ���
		kwSet = new ArrayList<ArrayList<String>>();
		position = new HashMap<String, NodePosition>();
		startTime = 0L;
		endTime = 0L;
		label.setText("");
		checkpanel.setEnabled(false);
	}

	private void BuildPosition() {
		// TODO Auto-generated method stub

		int i = 100, j = 100;
		for (Service prr : pr) {
			NodePosition np = new NodePosition();
			np.setX(i);
			np.setY(j);
			i += 40;
			position.put(prr.getSid(), np);
		}

		i = 160;
		j = 200;
		for (User arr : ar) {
			NodePosition np = new NodePosition();
			np.setX(i);
			np.setY(j);
			i += 120;
			position.put(arr.getUid(), np);
		}

		i = 160;
		j = 50;
		for (Order cee : ce) {
			NodePosition np = new NodePosition();
			String left = cee.getOrder();
			String right = cee.getOrdered();
			int ii = (position.get(left).getX() + position.get(right).getX()) / 2;

			np.setLeft(left);
			np.setRight(right);
			np.setX(ii);
			np.setY(j);
			position.put(left + right, np);
		}

		j = 150;
		for (Serviceuser paa : pa) {
			NodePosition np = new NodePosition();
			String left = paa.getSid();
			String right = paa.getUid();

			int kk = 0;
			if (position.get(left).getX() < position.get(right).getX()) {
				kk = (position.get(left).getX() + position.get(right).getX()) / 2 - 5;
			} else {
				kk = (position.get(left).getX() + position.get(right).getX()) / 2 + 5;
			}
			np.setLeft(left);
			np.setRight(right);
			np.setX(kk);
			np.setY(j);
			position.put(left + right, np);

		}
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		draw = new java.awt.Panel();
		label = new java.awt.Label();
		panel2 = new java.awt.Panel();
		show = new java.awt.Button();
		keyCheck = new java.awt.Button();
		label2 = new java.awt.Label();
		label3 = new java.awt.Label();
		ur = new java.awt.TextField();
		pw = new java.awt.TextField();
		checkpanel = new java.awt.Panel();
		label1 = new java.awt.Label();
		keytext = new java.awt.TextField();
		check = new java.awt.Button();

		ur.setText("root");
		pw.setText("root");
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setBackground(new java.awt.Color(0, 0, 0));
		setForeground(java.awt.Color.darkGray);

		draw.setBackground(new java.awt.Color(0, 202, 207));

		javax.swing.GroupLayout drawLayout = new javax.swing.GroupLayout(draw);
		draw.setLayout(drawLayout);
		drawLayout.setHorizontalGroup(drawLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				drawLayout.createSequentialGroup().addContainerGap(76,
						Short.MAX_VALUE).addComponent(label,
						javax.swing.GroupLayout.PREFERRED_SIZE, 598,
						javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		drawLayout.setVerticalGroup(drawLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				drawLayout.createSequentialGroup().addContainerGap(232,
						Short.MAX_VALUE).addComponent(label,
						javax.swing.GroupLayout.PREFERRED_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.PREFERRED_SIZE)));

		panel2.setBackground(new java.awt.Color(0, 232, 207));

		show.setLabel("\u663e\u793a\u6570\u636e\u56fe");
		show.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				showActionPerformed(evt);
			}
		});

		keyCheck.setLabel("\u5173\u952e\u8bcd\u67e5\u8be2");
		keyCheck.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				keyCheckActionPerformed(evt);
			}
		});

		label2.setText("\u7528\u6237\u540d");

		label3.setText("\u5bc6\u7801");

		ur.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				urActionPerformed(evt);
			}
		});

		pw.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				pwActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(
				panel2);
		panel2.setLayout(panel2Layout);
		panel2Layout
				.setHorizontalGroup(panel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								panel2Layout
										.createSequentialGroup()
										.addGroup(
												panel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																panel2Layout
																		.createSequentialGroup()
																		.addGap(
																				20,
																				20,
																				20)
																		.addGroup(
																				panel2Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								panel2Layout
																										.createSequentialGroup()
																										.addComponent(
																												ur,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												40,
																												Short.MAX_VALUE)
																										.addGap(
																												20,
																												20,
																												20))
																						.addComponent(
																								label2,
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								60,
																								Short.MAX_VALUE)
																						.addComponent(
																								label3,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								pw,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								40,
																								javax.swing.GroupLayout.PREFERRED_SIZE)))
														.addGroup(
																panel2Layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addGroup(
																				panel2Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								false)
																						.addComponent(
																								keyCheck,
																								javax.swing.GroupLayout.Alignment.LEADING,
																								0,
																								0,
																								Short.MAX_VALUE)
																						.addComponent(
																								show,
																								javax.swing.GroupLayout.Alignment.LEADING,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								67,
																								Short.MAX_VALUE))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				3,
																				Short.MAX_VALUE)))
										.addContainerGap()));
		panel2Layout
				.setVerticalGroup(panel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								panel2Layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												label2,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(2, 2, 2)
										.addComponent(
												ur,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(1, 1, 1)
										.addComponent(
												label3,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(2, 2, 2)
										.addComponent(
												pw,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												72, Short.MAX_VALUE)
										.addComponent(
												show,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(24, 24, 24)
										.addComponent(
												keyCheck,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(113, 113, 113)));

		checkpanel.setBackground(new java.awt.Color(0, 232, 207));

		label1.setText("\u8f93\u5165\u5173\u952e\u8bcd");

		keytext.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				keytextActionPerformed(evt);
			}
		});

		check.setLabel("\u67e5\u8be2");
		check.setName("check");
		check.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				checkActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout checkpanelLayout = new javax.swing.GroupLayout(
				checkpanel);
		checkpanel.setLayout(checkpanelLayout);
		checkpanelLayout
				.setHorizontalGroup(checkpanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								checkpanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												label1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												keytext,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												540, Short.MAX_VALUE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												check,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap()));
		checkpanelLayout
				.setVerticalGroup(checkpanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								checkpanelLayout
										.createSequentialGroup()
										.addGap(35, 35, 35)
										.addGroup(
												checkpanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																check,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGroup(
																checkpanelLayout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING)
																		.addComponent(
																				keytext,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				label1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(39, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												panel2,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																draw,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																checkpanel,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addContainerGap()));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																panel2,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addComponent(
																				checkpanel,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				draw,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addContainerGap()));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void urActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void pwActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		
	}

	private void keytextActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void cleardraw() {
		Graphics g = draw.getGraphics();
		int width = draw.getHeight();
		int height = draw.getWidth();
		// System.out.println(width+":"+height);
		g.clearRect(0, 0, height, width);
	}

	private void clearRef() {

		keyword.clear();
		kwSet.clear();
		kwnode_kw.clear();
		kwNode.clear();
		root_kw.clear();
		flag.clear();
		root.clear();
		rootTrace.clear();
		System.gc();
		startTime = System.currentTimeMillis();

		label.setText("��ʼ����......");
	}

	public void Dijskra(String sr) {
		String preNode = null;
		ArrayList<String> begin = new ArrayList<String>();
		ArrayList<String> initNode = new ArrayList<String>();

		for (String node : allNode) { //�ѷǶ����㣨���ڽӵ�ĵ㣩�����뵽 ʣ��ڵ㼯����
			if (graphicInfo.get(node).getAdj().size() == 0) {
				continue;
			}
			initNode.add(node);
		}

		DijInfo.get(sr).getAllNode().get(sr).setDist(0); //��ʼ����Դ�ڵ��ȨֵΪ0
		preNode = sr;
		begin.add(sr);
		initNode.remove(sr);

		while (begin.size() < allNode.size()) {

			String minadj = null; // ���ڱ����ɳں�Ȩֵ��С���ٽ��
			int minWeight = 10000;
			int j = 0;

			for (int i = 0; i < graphicInfo.get(preNode).getAdj().size(); i++) {
				String adj = graphicInfo.get(preNode).getAdj().get(i)
						.getNodename(); // �õ��ڽӵ�

				if (initNode.contains(adj)) { //��ʣ��ڵ㼯���а�������ڽӵ�ʱ������ɳ�

					int length = DijInfo.get(sr).getAllNode().get(preNode)
							.getDist()
							+ graphicInfo.get(preNode).getAdj().get(i)
									.getDist();

					if (length < DijInfo.get(sr).getAllNode().get(adj)
							.getDist()) // ���бߵ��ɳڴ���
					{
						DijInfo.get(sr).getAllNode().get(adj).setDist(length); //�������øõ�Ȩֵ
						DijInfo.get(sr).getAllNode().get(adj).setPre(preNode); //����õ����һ���ڵ�  Ϊ���������������׼��
						if (length < minWeight) { // �����ɳں���СȨֵ��
							minWeight = length;
							minadj = adj;
						}
					}
				} else {
					j++;
					if ((j == graphicInfo.get(preNode).getAdj().size())
							&& initNode.size() == 0) { //�����ڽӵ㶼����initNode�����У�������������������ѭ��
						return;
					}
					continue;
				}
			}

			minadj = initNode.get(0);
			for (String adjj : initNode) { //�ҵ�ʣ��ڵ���Ȩֵ��С���ǵ���Ϊ �´ο�ʼ������Դ�ڵ�
				if (DijInfo.get(sr).getAllNode().get(adjj).getDist() < DijInfo
						.get(sr).getAllNode().get(minadj).getDist()) {
					minadj = adjj;
				}
			}
			DijInfo.get(sr).getAllNode().get(preNode).setNext(minadj); //������С���������
			preNode = minadj; //����ʼ�ڵ�����Ϊ��С�ڵ�
			begin.add(minadj); //��Ȩֵ��С�ڵ���뵽begin����
			initNode.remove(minadj); //��Ȩֵ��С�ڵ��initNode������ɾ��
		}
	}

	public void Dij() { // Dijskra ��ؼ��ʽڵ㵽�������нڵ����̾��� kwNode allNode
		// ���ǹؼ��ʽڵ�����ظ�

		// ��ʼ��ʼ��
		for (int i = 0; i < kwNode.size(); i++) {
			if (DijInfo.containsKey(kwNode.get(i))) {
				continue;
			} else {
				DijGraphic dgp = new DijGraphic();
				dgp.setName(kwNode.get(i));
				for (int j = 0; j < allNode.size(); j++) {
					Node nd = new Node();
					nd.setNodename(allNode.get(j));
					nd.setDist(10000);
					nd.setBelong(kwNode.get(i));
					dgp.getAllNode().put(allNode.get(j), nd);

				}

				DijInfo.put(kwNode.get(i), dgp);
				// System.out.print(DijInfo.get("t1").getAllNode().get("t5").getNodename());
			}
		}
		// ��ʼ�����

		// ȥ���ؼ��ʽڵ��е��ظ��ڵ�
		ArrayList<String> newkwNode = new ArrayList<String>();
		for (String keyname : kwNode) {
			if (!newkwNode.contains(keyname)) {
				newkwNode.add(keyname);
			}
		}

		//����Dijskra�㷨��ÿ���ؼ��ʽڵ㵽ͼ�����нڵ�����·��
		for (String name : newkwNode) {
			Dijskra(name);
			Node e = DijInfo.get(name).getAllNode().get(name);
			while (e.getNext() != null) {
				System.out.print(e.getNodename() + ":" + e.getDist() + "-->");
				e = DijInfo.get(name).getAllNode().get(e.getNext());
			}
			System.out.print(e.getNodename() + ":" + e.getDist() + "\n");
		}

		/*Ϊͼ��ÿ���ڵ㽨�����ʱ�־ ��ʼ״̬0 ��ʾ δ����  
		 *��һ����Ϊ����Ĳ��Ҹ��ڵ���׼��
		 */
		for (String aa : allNode) {

			AccessFlag acf = new AccessFlag();

			for (String bb : keyword) {
				acf.getFlag().put(bb, 1);
			}
			flag.put(aa, acf);

		}

		//��ʼ��ÿ���ڵ��Ӧ�� �����ؼ��ʽڵ㼯��
		for (String an : allNode) {

			ArrayList<String> rootkw = new ArrayList<String>();
			root_kw.put(an, rootkw);
		}

		//����FindBase�㷨���ҿ��ܵĸ��ڵ�x
		FindBase fb = new FindBase();
		fb.setDinfo(DijInfo);
		for (String name : newkwNode) {
			fb.add(DijInfo.get(name).getAllNode().get(name));
		}

		Node minNode = fb.getMin();
		int count = 0;
		int rootCount = 0;
		int change = allNode.size();

		while (minNode != null) {

			count++;
			System.out.print(minNode.getNodename() + " ");
			if (count % change == 0) {
				System.out.println("");
			}

			String belongNode = minNode.getBelong();
			ArrayList<String> belongkw = kwnode_kw.get(belongNode);

			for (String aa : belongkw) {
				flag.get(minNode.getNodename()).getFlag().remove(aa);
				flag.get(minNode.getNodename()).getFlag().put(aa, 0); //����flag��ʾ�ýڵ㱻����
			}
			if (!root_kw.get(minNode.getNodename()).contains(belongNode)) //���δ���ùؼ��ʽڵ���ʹ��������
				root_kw.get(minNode.getNodename()).add(belongNode); //������¼��ֻ���ǵ�һ�����ڵ����ط��ʽڵ㡣

			if (flag.get(minNode.getNodename()).getSum() == 0) { //����ø��ڵ㱻���йؼ��ʷ���  ���뵽���ڵ㼯����
				rootCount++;
				root.add(minNode.getNodename());
				System.out.print("[" + minNode.getNodename() + "]" + "[");
				for (String rk : root_kw.get(minNode.getNodename())) {
					System.out.print(rk + ",");
				}
				System.out.print("] ");
				if (rootCount == 1) {
					break;
				}
			}

			minNode = fb.getMin();
		}

		//��ʼ�ع����ҵ�����СSteiner��
		if (root.size() == 0) {
			label.setText("û�м�������صĲ�ѯ���������������......");
			return; //û������Ҫ��ĸ��ڵ� ֱ�ӷ���
		}
		String finalRoot = root.get(0);
		ArrayList<String> finalRootKw = root_kw.get(finalRoot);
		for (String ff : finalRootKw) {
			ArrayList<String> trace = new ArrayList<String>();
			String str = DijInfo.get(ff).getAllNode().get(finalRoot).getPre();
			while (str != null) {
				trace.add(str);
				str = DijInfo.get(ff).getAllNode().get(str).getPre();
			}
			rootTrace.put(ff, trace);
		}

		label.setText("��ѯ�������СSteiner��������ʾ");
		System.out.println("\n��ʼ�����СSteiner��");

		ArrayList<String> steinerNode = new ArrayList<String>();
		ArrayList<String> steinerEdge = new ArrayList<String>();
		String left = finalRoot;
		steinerNode.add(finalRoot);
		for (String ff : finalRootKw) {
			ArrayList<String> gettrace = rootTrace.get(ff);
			System.out.print(finalRoot + ">>");
			for (String dd : gettrace) {
				steinerNode.add(dd);
				steinerEdge.add(left + dd);
				steinerEdge.add(dd + left);
				left = dd;
				System.out.print(dd + ">>");
			}
			left = finalRoot;
			System.out.println("");
		}

		DrawSteiner(steinerNode, steinerEdge);

		//System.out.println(DijInfo.size());

	}

	private void DrawSteiner(ArrayList<String> steinerNode,
			ArrayList<String> steinerEdge) {
		ArrayList<String> node = steinerNode;
		ArrayList<String> edge = steinerEdge;
		Graphics g = draw.getGraphics();
		g.setColor(new Color(255, 0, 0));

		for (String nn : node) {
			NodePosition np = position.get(nn);
			g.drawOval(np.getX(), np.getY(), 10, 10);
			g.fillOval(np.getX(), np.getY(), 10, 10);
		}
		int countDist = 0;

		ArrayList<String> accflag = new ArrayList<String>();

		for (String ee : edge) {
			NodePosition np = position.get(ee);
			if (np != null) {
				if (!accflag.contains(ee)) {
					countDist += 2;
					accflag.add(ee);
					NodePosition npa = position.get(np.getLeft());
					NodePosition npb = position.get(np.getRight());
					g.drawOval(np.getX(), np.getY(), 10, 10);
					g.fillOval(np.getX(), np.getY(), 10, 10);
					g.drawLine(np.getX() + 5, np.getY() + 5, npa.getX() + 5,
							npa.getY() + 5);
					g.drawLine(np.getX() + 5, np.getY() + 5, npb.getX() + 5,
							npb.getY() + 5);
				} else
					continue;
			}
		}
		StringBuffer lb = new StringBuffer();
		//lb.append(label.getText());
		System.gc();
		endTime = System.currentTimeMillis();
		Long time = endTime - startTime;
		String str = "���β�ѯ������" + time + "����,��СSteiner���Ĵ���Ϊ" + countDist;
		lb.append(str);
		label.setText(lb.toString());
	}


	private void checkActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code her

		cleardraw();
		clearRef();

		String text = keytext.getText();

		if (text.equals("")) {
			JOptionPane.showMessageDialog(null, "���������ѯ�ؼ��ʣ��Կո���ָ��� ", "��ʾ",
					JOptionPane.ERROR_MESSAGE);
			label.setText("��������......");
			return;
		}

		String[] kw = text.split(" ");
		for (String kww : kw) {
			keyword.add(kww);
		}

		ArrayList<String> temp = new ArrayList<String>();
		ArrayList<String> dele = new ArrayList<String>();
		for (String kww : keyword) {
			temp = new ArrayList<String>();
			for (Service prr : pr) {
				if (prr.getSname().indexOf(kww) >= 0) {
					temp.add(prr.getSid());
					if (kwnode_kw.containsKey(prr.getSid()))
						kwnode_kw.get(prr.getSid()).add(kww);
					else {
						ArrayList<String> kk = new ArrayList<String>();
						kk.add(kww);
						kwnode_kw.put(prr.getSid(), kk);
					}
				}
			}
			for (User arr : ar) {
				if (arr.getName().indexOf(kww) >= 0) {
					temp.add(arr.getUid());
					if (kwnode_kw.containsKey(arr.getUid()))
						kwnode_kw.get(arr.getUid()).add(kww);
					else {
						ArrayList<String> kk = new ArrayList<String>();
						kk.add(kww);
						kwnode_kw.put(arr.getUid(), kk);
					}
				}
			}
			if (temp.size() == 0)
				dele.add(kww);
			else {
				kwSet.add(temp); // ��ĳ����ѯ�ؼ��ʶ�Ӧ�Ĺؼ��ʽڵ㼯�ϼ��뵽�����С�
			}
		}
		for (String dd : dele) {
			keyword.remove(dd); //ɾ����Щû����عؼ��ʽڵ�Ĺؼ��� ���������û��������Ĺؼ���ʱ��  ֱ������  ֻ�����йؼ��ʽڵ�Ĺؼ���
		}

		for (ArrayList<String> lt : kwSet) {
			for (int i = 0; i < lt.size(); i++) {
				kwNode.add((String) (lt).get(i)); // ���ɹؼ��ʽڵ�
			}
		}
		Dij();
	}

	private void keyCheckActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here
		cleardraw();
		if(pa!=null)
			checkpanel.setEnabled(true);
		else
			checkpanel.setEnabled(false);
	}

	public void BuildTreeByDB() throws SQLException {

		Graphics g = draw.getGraphics();
		g.setColor(new Color(255, 0, 0));

		for (Service prr : pr) {
			NodePosition np = position.get(prr.getSid());
			g.drawOval(np.getX(), np.getY(), 10, 10);
			g.fillOval(np.getX(), np.getY(), 10, 10);
		}
		for (User arr : ar) {
			NodePosition np = position.get(arr.getUid());
			g.drawOval(np.getX(), np.getY(), 10, 10);
			g.fillOval(np.getX(), np.getY(), 10, 10);
		}
		for (Order cee : ce) {
			NodePosition np = position.get(cee.getOrder() + cee.getOrdered());
			g.drawOval(np.getX(), np.getY(), 10, 10);
			g.fillOval(np.getX(), np.getY(), 10, 10);
			NodePosition npleft = position.get(cee.getOrder());
			NodePosition npright = position.get(cee.getOrdered());
			g.drawLine(np.getX() + 5, 55, npleft.getX() + 5, 105);
			g.drawLine(np.getX() + 5, 55, npright.getX() + 5, 105);
		}
		for (Serviceuser paa : pa) {
			NodePosition np = position.get(paa.getSid() + paa.getUid());
			g.drawOval(np.getX(), np.getY(), 10, 10);
			g.fillOval(np.getX(), np.getY(), 10, 10);
			NodePosition npleft = position.get(paa.getSid());
			NodePosition npright = position.get(paa.getUid());
			g.drawLine(np.getX() + 5, 155, npleft.getX() + 5, 105);
			g.drawLine(np.getX() + 5, 155, npright.getX() + 5, 205);
		}
	}

	public void BuildGraphic() {

		for (Service prr : pr) {
			Graphic gp = new Graphic();
			gp.setName(prr.getSid());
			graphicInfo.put(prr.getSid(), gp);

			allNode.add(prr.getSid());
		}

		for (User arr : ar) {
			Graphic gp = new Graphic();
			gp.setName(arr.getUid());
			graphicInfo.put(arr.getUid(), gp);

			allNode.add(arr.getUid());
		}

		for (Order cee : ce) {
			Node nd1 = new Node();
			Node nd2 = new Node();

			nd1.setNodename(cee.getOrder());
			nd1.setDist(2);
			nd2.setNodename(cee.getOrdered());
			nd2.setDist(2);

			graphicInfo.get(cee.getOrder()).getAdj().add(nd2);
			graphicInfo.get(cee.getOrdered()).getAdj().add(nd1);
		}

		for (Serviceuser paa : pa) {

			Node nd1 = new Node();
			Node nd2 = new Node();

			nd1.setNodename(paa.getSid());
			nd1.setDist(2);

			nd2.setNodename(paa.getUid());
			nd2.setDist(2);

			graphicInfo.get(paa.getSid()).getAdj().add(nd2);
			graphicInfo.get(paa.getUid()).getAdj().add(nd1);

		}
	}


	public void showActionPerformed(java.awt.event.ActionEvent evt)
			 {
		// TODO add your handling code here:

		cleardraw();
		try{
		initMine();
		BuildTree bt = new BuildTree(ur.getText(),pw.getText());
		ar = bt.getAuthorList();
		pr = bt.getPaperList();
		ce = bt.getCiteList();
		pa = bt.getPaperAuthorList();
		BuildGraphic();
		BuildPosition();
		BuildTreeByDB();
		}catch(Exception e){
			//System.out.println(e);
			return ;
		}
		checkpanel.setEnabled(true);

	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				Mainwindow mf = null;
				mf = new Mainwindow();
				mf.setTitle("����BANKS������ͼ��СSteiner����ѯ��");
				mf.getContentPane().setBackground(Color.GRAY);
				mf.setVisible(true);
				mf.setLocation(350, 200);

			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private java.awt.Button check;
	private java.awt.Panel checkpanel;
	private java.awt.Panel draw;
	private java.awt.Button keyCheck;
	private java.awt.TextField keytext;
	private java.awt.Label label;
	private java.awt.Label label1;
	private java.awt.Label label2;
	private java.awt.Label label3;
	private java.awt.Panel panel2;
	private java.awt.TextField pw;
	private java.awt.Button show;
	private java.awt.TextField ur;
	// End of variables declaration//GEN-END:variables
	private ArrayList<User> ar;
	private ArrayList<Service> pr;
	private ArrayList<Order> ce;
	private ArrayList<Serviceuser> pa;

	ArrayList<String> keyword; //��¼�û���������йؼ��� 
	ArrayList<ArrayList<String>> kwSet; // �洢�ؼ��ʶ�Ӧ�Ĺؼ��ʽڵ㼯�ϵļ���
	HashMap<String, Graphic> graphicInfo; // ���ڱ���ͼ�����ݽṹ
	HashMap<String, DijGraphic> DijInfo; // ���ڴ洢�ؼ��ʽڵ��������ڵ�ľ���
	ArrayList<String> kwNode; // �ؼ��ʽڵ㼯��
	ArrayList<String> allNode; // ͼ�����нڵ�ļ���
	HashMap<String, ArrayList<String>> kwnode_kw; //�ؼ��ʽڵ��Ӧ�ؼ���
	HashMap<String, AccessFlag> flag; //��¼ÿ���ڵ�ķ������
	ArrayList<String> root; //��¼���ҵĸ��ڵ�
	HashMap<String, ArrayList<String>> root_kw; //��¼�鵽�ĸ��ڵ��Ӧ�Ĺؼ��ʽڵ�
	HashMap<String, ArrayList<String>> rootTrace;//������ڵ㵽��Ӧ��ÿ�����ڵ�����·��
	HashMap<String, NodePosition> position; //��������ͼÿ�����λ��
	Long startTime; //��ʼ��ʱʱ��
	Long endTime; //������ʱʱ��
}