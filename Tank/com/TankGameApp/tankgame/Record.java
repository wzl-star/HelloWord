package com.TankGameApp.tankgame;

import java.io.*;
import java.util.Vector;

public class Record {
    private static int cost1 = 0;
    private static BufferedWriter bw = null;
    private static BufferedReader br = null;
    private static String recordFath = "e:\\record.txt";
    private static Vector<EnemyTank> enemyTanks = null;
    private static Vector<Notes> notes = new Vector<>();

    public static Vector<Notes> getNotes() {
        return notes;
    }

    public static void setNotes(Vector<Notes> notes) {
        Record.notes = notes;
    }

    public static void setEnemyTank(Vector<EnemyTank> enemyTanks) {
        Record.enemyTanks = enemyTanks;
    }

    public static String getRecordFath() {
        return recordFath;
    }

    public static Vector<Notes> loadRecord() {
        try {
            br = new BufferedReader(new FileReader(recordFath));
            cost1 = Integer.parseInt(br.readLine());
            String node = "";
            while ((node = br.readLine()) != null) {
                String xyz[] = node.split(" ");
                Notes notes1 = new Notes(Integer.parseInt(xyz[0]), Integer.parseInt(xyz[1]),
                        Integer.parseInt(xyz[2]));
                notes.add(notes1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return notes;
    }


    public static void keepRecord() {
        try {
            bw = new BufferedWriter(new FileWriter(recordFath));
            bw.write(cost1 + "");
            bw.newLine();
            for (int i = 0; i < enemyTanks.size(); i++) {
                EnemyTank enemyTank = Record.enemyTanks.get(i);
                String dl = enemyTank.getX() + " " + enemyTank.getY() + " " + enemyTank.getDirect();
                bw.write(dl);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static int getCost1() {
        return cost1;
    }

    public static void setCost1(int cost1) {
        Record.cost1 = cost1;
    }

    public static void costing() {
        Record.cost1++;
    }

}
