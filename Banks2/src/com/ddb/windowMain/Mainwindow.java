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
        keyword = new ArrayList<String>(); // 保存用户输入的查询关键词
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
        for (sequence cee : ce) {
            NodePosition np = new NodePosition();
            String left = cee.getSequence();
            String right = cee.getSequenced();
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

        label.setText("开始检索......");
    }

    public void Dijskra(String sr) {
        String preNode = null;
        ArrayList<String> begin = new ArrayList<String>();
        ArrayList<String> initNode = new ArrayList<String>();

        for (String node : allNode) { //把非独立点（有邻接点的点）都加入到 剩余节点集合中
            if (graphicInfo.get(node).getAdj().size() == 0) {
                continue;
            }
            initNode.add(node);
        }

        DijInfo.get(sr).getAllNode().get(sr).setDist(0); //初始设置源节点的权值为0
        preNode = sr;
        begin.add(sr);
        initNode.remove(sr);

        while (begin.size() < allNode.size()) {

            String minadj = null; // 用于保存松弛后权值最小的临界点
            int minWeight = 10000;
            int j = 0;

            for (int i = 0; i < graphicInfo.get(preNode).getAdj().size(); i++) {
                String adj = graphicInfo.get(preNode).getAdj().get(i)
                        .getNodename(); // 得到邻接点

                if (initNode.contains(adj)) { //当剩余节点集合中包含这个邻接点时候进行松弛

                    int length = DijInfo.get(sr).getAllNode().get(preNode)
                            .getDist()
                            + graphicInfo.get(preNode).getAdj().get(i)
                            .getDist();

                    if (length < DijInfo.get(sr).getAllNode().get(adj)
                            .getDist()) // 进行边的松弛处理
                    {
                        DijInfo.get(sr).getAllNode().get(adj).setDist(length); //重新设置该点权值
                        DijInfo.get(sr).getAllNode().get(adj).setPre(preNode); //保存该点的上一个节点  为后面的重组树而做准备
                        if (length < minWeight) { // 保存松弛后最小权值边
                            minWeight = length;
                            minadj = adj;
                        }
                    }
                } else {
                    j++;
                    if ((j == graphicInfo.get(preNode).getAdj().size())
                            && initNode.size() == 0) { //所有邻接点都不在initNode集合中，遍历结束，跳出整个循环
                        return;
                    }
                    continue;
                }
            }

            minadj = initNode.get(0);
            for (String adjj : initNode) { //找到剩余节点中权值最小的那点作为 下次开始遍历的源节点
                if (DijInfo.get(sr).getAllNode().get(adjj).getDist() < DijInfo
                        .get(sr).getAllNode().get(minadj).getDist()) {
                    minadj = adjj;
                }
            }
            DijInfo.get(sr).getAllNode().get(preNode).setNext(minadj); //建立从小到大的索引
            preNode = minadj; //将开始节点设置为最小节点
            begin.add(minadj); //将权值最小节点加入到begin集合
            initNode.remove(minadj); //将权值最小节点从initNode集合中删除
        }
    }

    public void Dij() { // Dijskra 求关键词节点到其他所有节点的最短距离 kwNode allNode
        // 考虑关键词节点可能重复

        // 开始初始化
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
        // 初始化完成

        // 去除关键词节点中的重复节点
        ArrayList<String> newkwNode = new ArrayList<String>();
        for (String keyname : kwNode) {
            if (!newkwNode.contains(keyname)) {
                newkwNode.add(keyname);
            }
        }

        //调用Dijskra算法求每个关键词节点到图中所有节点的最短路径
        for (String name : newkwNode) {
            Dijskra(name);
            Node e = DijInfo.get(name).getAllNode().get(name);
            while (e.getNext() != null) {
                System.out.print(e.getNodename() + ":" + e.getDist() + "-->");
                e = DijInfo.get(name).getAllNode().get(e.getNext());
            }
            System.out.print(e.getNodename() + ":" + e.getDist() + "\n");
        }

        /*为图中每个节点建立访问标志 初始状态0 表示 未访问
         *这一步是为下面的查找根节点做准备
         */
        for (String aa : allNode) {

            AccessFlag acf = new AccessFlag();

            for (String bb : keyword) {
                acf.getFlag().put(bb, 1);
            }
            flag.put(aa, acf);

        }

        //初始化每个节点对应的 所属关键词节点集合
        for (String an : allNode) {

            ArrayList<String> rootkw = new ArrayList<String>();
            root_kw.put(an, rootkw);
        }

        //调用FindBase算法查找可能的根节点x
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
                flag.get(minNode.getNodename()).getFlag().put(aa, 0); //设置flag表示该节点被访问
            }
            if (!root_kw.get(minNode.getNodename()).contains(belongNode)) //如果未被该关键词节点访问过，就添加
                root_kw.get(minNode.getNodename()).add(belongNode); //这样记录的只能是第一个根节点的相关访问节点。

            if (flag.get(minNode.getNodename()).getSum() == 0) { //如果该根节点被所有关键词访问  加入到根节点集合中
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

        //开始重构查找到的最小Steiner树
        if (root.size() == 0) {
            label.setText("没有检索到相关的查询结果，请重新输入......");
            return; //没有满足要求的根节点 直接返回
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

        label.setText("查询结果的最小Steiner树如上所示");
        System.out.println("\n开始输出最小Steiner树");

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
        String str = "本次查询共消耗" + time + "毫秒,最小Steiner树的代价为" + countDist;
        lb.append(str);
        label.setText(lb.toString());
    }


    private void checkActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code her

        cleardraw();
        clearRef();

        String text = keytext.getText();

        if (text.equals("")) {
            JOptionPane.showMessageDialog(null, "请先输入查询关键词（以空格符分隔） ", "提示",
                    JOptionPane.ERROR_MESSAGE);
            label.setText("检索结束......");
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
                kwSet.add(temp); // 把某个查询关键词对应的关键词节点集合加入到集合中。
            }
        }
        for (String dd : dele) {
            keyword.remove(dd); //删除那些没有相关关键词节点的关键词 ，这样当用户输入错误的关键词时候  直接屏蔽  只考虑有关键词节点的关键词
        }

        for (ArrayList<String> lt : kwSet) {
            for (int i = 0; i < lt.size(); i++) {
                kwNode.add((String) (lt).get(i)); // 生成关键词节点
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
        for (sequence cee : ce) {
            NodePosition np = position.get(cee.getSequence() + cee.getSequenced());
            g.drawOval(np.getX(), np.getY(), 10, 10);
            g.fillOval(np.getX(), np.getY(), 10, 10);
            NodePosition npleft = position.get(cee.getSequence());
            NodePosition npright = position.get(cee.getSequenced());
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

        for (sequence cee : ce) {
            Node nd1 = new Node();
            Node nd2 = new Node();

            nd1.setNodename(cee.getSequence());
            nd1.setDist(2);
            nd2.setNodename(cee.getSequenced());
            nd2.setDist(2);

            graphicInfo.get(cee.getSequence()).getAdj().add(nd2);
            graphicInfo.get(cee.getSequenced()).getAdj().add(nd1);
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
            ar = bt.getUserList();
            pr = bt.getServiceList();
            ce = bt.getSequenceList();
            pa = bt.getServiceUserlist();
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
                mf.setTitle("基于BANKS的数据图最小Steiner树查询器");
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
    private ArrayList<sequence> ce;
    private ArrayList<Serviceuser> pa;

    ArrayList<String> keyword; //记录用户输入的所有关键词
    ArrayList<ArrayList<String>> kwSet; // 存储关键词对应的关键词节点集合的集合
    HashMap<String, Graphic> graphicInfo; // 用于保存图的数据结构
    HashMap<String, DijGraphic> DijInfo; // 用于存储关键词节点与其他节点的距离
    ArrayList<String> kwNode; // 关键词节点集合
    ArrayList<String> allNode; // 图中所有节点的集合
    HashMap<String, ArrayList<String>> kwnode_kw; //关键词节点对应关键词
    HashMap<String, AccessFlag> flag; //记录每个节点的访问情况
    ArrayList<String> root; //记录查找的根节点
    HashMap<String, ArrayList<String>> root_kw; //记录查到的根节点对应的关键词节点
    HashMap<String, ArrayList<String>> rootTrace;//保存根节点到对应的每个根节点的最短路径
    HashMap<String, NodePosition> position; //保存数据图每个点的位置
    Long startTime; //开始计时时间
    Long endTime; //结束计时时间
}
