/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package baseinvaders;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;
import javax.imageio.ImageIO;

/**
 *
 * @author Sasa
 */
public class Configurations {

    private static int port = 17429;
    private static int uiPort = 17428;
    private static int biUiPort = 14739;
    private static String host = "127.0.0.1";
    private static final Map<String, String> users = new ConcurrentHashMap<>();
    private static long timeout = 20;
    private static long uiTimeout = 20;
    private static int maxConnectionsPerUser = 3;
    private static Long ticksRemaining = 48000L;
    private static Long downtimeTicks = 1200L;
    private static long tickDelay = 25;


    private static double friction = .99;
    private static double brakeFriction = .987;
    private static double speed = .1;

    private static double fixedDelta = tickDelay / 1000.0;
    private static double ticksPerSec = 1.0 / fixedDelta;
    private static double defaultAcceleration = 200; // per second
    private static double maxSpeed = 1000; // per second
    private static double percentOfDestinationToSlowdown = 0.3;
    private static double arrivalDistance = 1;
    private static double mineralPerSecondTime = 1.0; // 1 mineral per X second
    private static long mineralCapacity = 500; // Max minerals held at one time

    private static double captureRadius = 5;
    private static double visionRadius = 150;
    private static int maxBombs = 1;
    private static double bombPlacementRadius = 50;
    private static double bombExplosionRadius = 150;
    private static long bombDelay = 100;
    private static long minBombDelay = 20, maxBombDelay = 200;
    private static double bombPower = 15;
    private static double scanRadius = 500;
    private static long scanDelay = 100;
    private static long moveToDelay = 100;

    private static double minWormHoleRadius = 150, maxWormHoleRadius = 500;
    private static double wormHoleCenterRadius = 10;
    private static double wormHoleGravity = 2;
    private static int wormHoleCount = 0;
    private static int mineCount = 30;
    private static int stationCount = 2;
    private static int mapWidth = 10000, mapHeight = 10000;
    private static boolean useLocalUi = true;

    private static long mineMaxResources = 1000;
    private static long mineResourceAmount = 2;
    private static long mineResourceReplenishAmount = 1; 
    private static float mineDisplayMinAlpha = 0.4f;

    private static final List<Image> shipImages = new ArrayList<>();

    private static InputStream getResource(String name) {
        return Configurations.class.getClassLoader().getResourceAsStream(name);
    }

    private static boolean inited = false;

    private static void init() {
        if (inited) {
            return;
        }
        inited = true;
        try {
            BufferedImage spaceships = ImageIO.read(getResource("spaceships.png"));
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 3; j++) {
                    BufferedImage subimage = spaceships.getSubimage(48 * j, i * 24, 24, 24);
                    for (int k = 0; k < 24; k++) {
                        for (int l = 0; l < 24; l++) {
                            if (subimage.getRGB(k, l) == -1 || subimage.getRGB(k, l) == -921103) {
                                subimage.setRGB(k, l, 0x00000000);
                            }
                        }
                    }
                    shipImages.add(subimage);
                }
            }
            Collections.shuffle(shipImages, new Random(14729));
        } catch (IOException ex) {
        }
        //INIT PARAMS HERE
    }

    public static Image getPlayerImage(int id) {
        return shipImages.get(id % shipImages.size());
    }

    public static int getPort() {
        return port;
    }

    public static String getHost() {
        return host;
    }

    public static int getUiPort() {
        return uiPort;
    }

    public static int getBiUiPort() {
        return biUiPort;
    }

    public static double getMinWormHoleRadius() {
        return minWormHoleRadius;
    }

    public static double getMaxWormHoleRadius() {
        return maxWormHoleRadius;
    }

    public static double getWormHoleCenterRadius() {
        return wormHoleCenterRadius;
    }

    public static double getWormHoleGravity() {
        return wormHoleGravity;
    }

    public static int getWormHoleCount() {
        return wormHoleCount;
    }

    public static Set<String> getUsers() {
        return users.keySet();
    }

    public static String getUserPassword(String user) {
        if (!users.containsKey(user)) {
            throw new IllegalArgumentException("No Such User");
        }
        return users.get(user);
    }

    public static long getTimeout() {
        return timeout;
    }

    public static long getUITimeout() {
        return uiTimeout;
    }

    public static int getMaxConnectionsPerUser() {
        return maxConnectionsPerUser;
    }

    public static Long getTicksRemaining() {
        return ticksRemaining;
    }

    public static double getFriction() {
        return friction;
    }

    public static double getSpeed() {
        return speed;
    }

    public static double getFixedDelta() {
        return fixedDelta;
    }

    public static double getTicksPerSec() {
        return ticksPerSec;
    }

    public static double getDefaultAcceleration() {
        return defaultAcceleration;
    }

    public static double getMaxSpeed() {
        return maxSpeed;
    }

    public static double getPercentOfDestinationToSlowdown() {
        return percentOfDestinationToSlowdown;
    }

    public static double getArrivalDistance() {
        return arrivalDistance;
    }

    public static double getMineralPerSecondTime() {
        return mineralPerSecondTime;
    }

    public static long getMineralCapacity() {
        return mineralCapacity;
    }

    public static double getCaptureRadius() {
        return captureRadius;
    }

    public static int getMapWidth() {
        return mapWidth;
    }

    public static int getMapHeight() {
        return mapHeight;
    }

    public static double getBrakeFriction() {
        return brakeFriction;
    }

    public static int getMineCount() {
        return mineCount;
    }

    public static int getStationCount() {
        return stationCount;
    }

    public static double getVisionRadius() {
        return visionRadius;
    }

    public static int getMaxBombs() {
        return maxBombs;
    }

    public static long getBombDelay() {
        return bombDelay;
    }

    public static long getMinBombDelay() {
        return minBombDelay;
    }

    public static long getMaxBombDelay() {
        return maxBombDelay;
    }

    public static double getBombPower() {
        return bombPower;
    }

    public static double getBombPlacementRadius() {
        return bombPlacementRadius;
    }

    public static double getBombExplosionRadius() {
        return bombExplosionRadius;
    }

    public static double getScanRadius() {
        return scanRadius;
    }

    public static long getScanDelay() {
        return scanDelay;
    }

    public static long getMoveToDelay() {
        return moveToDelay;
    }

    public static Long getDowntimeTicks() {
        return downtimeTicks;
    }

    public static long getTickDelay() {
        return tickDelay;
    }

    public static long getMineMaxResources() {
        return mineMaxResources;
    }

    public static long getMineResourceAmount() {
        return mineResourceAmount;
    }

    public static long getMineResourceReplenishAmount() {
        return mineResourceReplenishAmount;
    }

    public static float getMineDisplayMinAlpha() {
        return mineDisplayMinAlpha;
    }

    public static String getConfigData() {
        return mapWidth + " " + mapHeight + " " + mineCount + " " + captureRadius + " " + speed + " " + friction + " "
                + brakeFriction + " " + scanRadius + " " + scanDelay + " " + bombPlacementRadius + " "
                + bombExplosionRadius + " " + bombPower + " " + bombDelay + " " + minBombDelay + " " + maxBombDelay + " "
                + mineMaxResources + " " + mineResourceAmount + " " + mineResourceReplenishAmount + " " + moveToDelay;
    }

    public static boolean getUseLocalUI() {
        return useLocalUi;
    }

    public static void readCongfigs(String file, boolean isFile) throws IOException {
        init();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(isFile ? new FileInputStream(file) : getResource(file)))) {
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line);
                if (!st.hasMoreTokens()) {
                    continue;
                }
                switch (st.nextToken()) {
                case "port":
                    port = Integer.parseInt(st.nextToken());
                    break;
                case "uiport":
                    uiPort = Integer.parseInt(st.nextToken());
                    break;
                case "biuiport":
                    biUiPort = Integer.parseInt(st.nextToken());
                    break;
                case "host":
                    host = st.nextToken();
                    break;
                case "users":
                    while (st.hasMoreTokens()) {
                        users.put(st.nextToken(), st.nextToken());
                    }
                    break;
                case "timeout":
                    timeout = Long.parseLong(st.nextToken());
                    break;
                case "uitimeout":
                    uiTimeout = Long.parseLong(st.nextToken());
                    break;
                case "ticks-remaining":
                    ticksRemaining = Long.parseLong(st.nextToken());
                    break;
                case "downtime-ticks":
                    downtimeTicks = Long.parseLong(st.nextToken());
                    break;
                case "tick-delay":
                    tickDelay = Long.parseLong(st.nextToken());
                    break;
                case "max-connections":
                    maxConnectionsPerUser = Integer.parseInt(st.nextToken());
                    break;
                case "map":
                    mapWidth = Integer.parseInt(st.nextToken());
                    mapHeight = Integer.parseInt(st.nextToken());
                    break;
                case "friction":
                    friction = Double.parseDouble(st.nextToken());
                    break;
                case "brake":
                    brakeFriction = Double.parseDouble(st.nextToken());
                    break;
                case "speed":
                    speed = Double.parseDouble(st.nextToken());
                    break;
                case "fixedDelta":
                    fixedDelta = Double.parseDouble(st.nextToken());
                    break;
                case "getTicksPerSec":
                    ticksPerSec = Double.parseDouble(st.nextToken());
                    break;
                case "defaultAcceleration":
                    defaultAcceleration = Double.parseDouble(st.nextToken());
                    break;
                case "maxSpeed":
                    maxSpeed = Double.parseDouble(st.nextToken());
                    break;
                case "percentOfDestinationToSlowdown":
                    percentOfDestinationToSlowdown = Double.parseDouble(st.nextToken());
                    break;
                case "arrivalDistance":
                    arrivalDistance = Double.parseDouble(st.nextToken());
                    break;
                case "mineralPerSecondTime":
                    mineralPerSecondTime = Double.parseDouble(st.nextToken());
                    break;
                case "mineralCapacity":
                    mineralCapacity = Long.parseLong(st.nextToken());
                    break;
                case "capture-radius":
                    captureRadius = Double.parseDouble(st.nextToken());
                    break;
                case "mines":
                    mineCount = Integer.parseInt(st.nextToken());
                    break;
                case "stations":
                    stationCount = Integer.parseInt(st.nextToken());
                    break;
                case "vision-radius":
                    visionRadius = Double.parseDouble(st.nextToken());
                    break;
                case "max-bombs":
                    maxBombs = Integer.parseInt(st.nextToken());
                    break;
                case "bomb-palacement-radius":
                    bombPlacementRadius = Double.parseDouble(st.nextToken());
                    break;
                case "bomb-explosion-radius":
                    bombExplosionRadius = Double.parseDouble(st.nextToken());
                    break;
                case "bomb-delay":
                    bombDelay = Long.parseLong(st.nextToken());
                    if (st.hasMoreTokens()) {
                        minBombDelay = Long.parseLong(st.nextToken());
                        maxBombDelay = Long.parseLong(st.nextToken());
                    }
                    break;
                case "bomb-power":
                    bombPower = Double.parseDouble(st.nextToken());
                    break;
                case "scan-radius":
                    scanRadius = Double.parseDouble(st.nextToken());
                    break;
                case "scan-delay":
                    scanDelay = Long.parseLong(st.nextToken());
                    break;
                case "moveToDelay":
                    moveToDelay = Long.parseLong(st.nextToken());
                    break;
                case "wormhole-count":
                    wormHoleCount = Integer.parseInt(st.nextToken());
                    break;
                case "mine-max-resources":
                    mineMaxResources = Long.parseLong(st.nextToken());
                    break;
                case "mine-resource-amount":
                    mineResourceAmount = Long.parseLong(st.nextToken());
                    break;
                case "mine-resource-replenish-amount":
                    mineResourceReplenishAmount = Long.parseLong(st.nextToken());
                    break;
                case "use-local-ui":
                    switch (st.nextToken()) {
                    case "true":
                        useLocalUi = true;
                        break;
                    case "false":
                        useLocalUi = false;
                        break;
                    default:
                        System.out.println("use-local-ui must be {true, false}, defaulting true");
                        break;
                    }
                    break;
                default:
                    if (line.charAt(0) != '#') {
                        System.out.println("Oops no such setting " + line);
                    }
                    break;
                }
            }
        }
    }

    public static void saveConfigurations(String file) throws IOException {
        try (PrintWriter pw = new PrintWriter(new File(file))) {
            pw.print(getConfigString());
        }
    }

    public static String getConfigString() {
        StringBuilder out = new StringBuilder();
        out.append("port ").append(port).append("\nhost ").append(host).append("\n");
        out.append("users ");
        users.entrySet().forEach((user) -> {
            out.append(user.getKey()).append(" ").append(user.getValue());
        });
        out.append("\n");
        out.append("timeout ").append(timeout).append("\n");
        out.append("ticks-remaining ").append(ticksRemaining).append("\n");
        return out.toString();
    }

    public static String getPlayerConfigString() {
        StringBuilder out = new StringBuilder();
        out.append("MAPWIDTH ").append(mapWidth);
        out.append(" MAPHEIGHT ").append(mapHeight);
        out.append(" CAPTURERADIUS ").append(captureRadius);
        out.append(" VISIONRADIUS ").append(visionRadius);
        out.append(" FRICTION ").append(friction);
        out.append(" BRAKEFRICTION ").append(brakeFriction);
        out.append(" BOMBPLACERADIUS ").append(bombPlacementRadius);
        out.append(" BOMBEFFECTRADIUS ").append(bombExplosionRadius);
        out.append(" BOMBDELAY ").append(bombDelay / ticksPerSec);
        out.append(" BOMBPOWER ").append(bombPower);
        out.append(" SCANRADIUS ").append(scanRadius);
        out.append(" SCANDELAY ").append(scanDelay / ticksPerSec);
        out.append(" MINEMAXRESOURCES ").append(mineMaxResources);
        out.append(" MINERESOURCEAMOUNT ").append(mineResourceAmount);
        out.append(" MINERESOURCEREPLENISHAMOUNT ").append(mineResourceReplenishAmount);
        out.append(" MOVETODELAY ").append(moveToDelay / ticksPerSec).append(" ");
        return out.toString();
    }

    private Configurations() {

    }
}
