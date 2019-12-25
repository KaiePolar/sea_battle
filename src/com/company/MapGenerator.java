package com.company;

public class MapGenerator {

    private char[][] map;
    private static final char q = 'q';
    private static final char one = '1';
    private static final char o = 'o';

    public MapGenerator() {
        map = new char[12][12];
        for (int i = 0; i < 12; i++) {
            for (int k = 0; k < 12; k++) {
                map[i][k] = 'o';
            }
        }
    }

    public char[][] generateMap() {
        generate4Xship();
        generate3Xship();
        generate3Xship();
        generate2Xship();
        generate2Xship();
        generate2Xship();
        generate1Xship();
        generate1Xship();
        generate1Xship();
        generate1Xship();

        char[][] newMap = new char[10][10];
        for (byte x = 1; x < 11; x++) {
            for (byte y = 1; y < 11; y++) {
                newMap[x - 1][y - 1] = map[x][y];
            }
        }
        map = newMap;
        clearMapFromQs();
        return map;
    }

    public void generate4Xship() {
        byte z = (byte) (Math.random() * 11);
        byte xAxis, x, yAxis, y;
        if (z < 5) {
            xAxis = (byte) ((Math.random() * 7) + 1);
            x = xAxis;
            yAxis = (byte) ((Math.random() * 10) + 1);
            y = yAxis;
            map[xAxis][yAxis] = one;
            ++xAxis;
            map[xAxis][yAxis] = one;
            ++xAxis;
            map[xAxis][yAxis] = one;
            ++xAxis;
            map[xAxis][yAxis] = one;
            for (byte i = -1; i < 4 + 1; i++) {
                try {
                    map[x + i][y + 1] = q;
                    map[x + i][y - 1] = q;
                    map[x - 1][y] = q;
                    map[x + 4][y] = q;
                } catch (ArrayIndexOutOfBoundsException io) {
                }
            }
        } else {
            xAxis = (byte) ((Math.random() * 10) + 1);
            x = xAxis;
            yAxis = (byte) ((Math.random() * 7) + 1);
            y = yAxis;
            map[xAxis][yAxis] = one;
            ++yAxis;
            map[xAxis][yAxis] = one;
            ++yAxis;
            map[xAxis][yAxis] = one;
            ++yAxis;
            map[xAxis][yAxis] = one;
            for (int i = -1; i < 4 + 1; i++) {
                try {
                    map[x + 1][y + i] = q;
                    map[x - 1][y + i] = q;
                    map[x][y - 1] = q;
                    map[x][y + 4] = q;
                } catch (ArrayIndexOutOfBoundsException io) {
                }
            }
        }
    }

    public void generate3Xship() {
        byte z = (byte) (Math.random() * 11);
        byte xAxis, x, yAxis, y;
        if (z < 5) {
            xAxis = (byte) ((Math.random() * 8) + 1);
            x = xAxis;
            yAxis = (byte) ((Math.random() * 10) + 1);
            y = yAxis;
            if ((map[xAxis][yAxis] == o) & (map[xAxis + 1][yAxis] == o) & (map[xAxis + 2][yAxis] == o)) {
                if ((map[xAxis][yAxis + 1] != one) & (map[xAxis + 1][yAxis + 1] != one) & (map[xAxis + 2][yAxis + 1] != one)) {
                    if ((map[xAxis][yAxis - 1] != one) & (map[xAxis + 1][yAxis - 1] != one) & (map[xAxis + 2][yAxis - 1] != one)) {
                        map[xAxis][yAxis] = one;
                        ++xAxis;
                        map[xAxis][yAxis] = one;
                        ++xAxis;
                        map[xAxis][yAxis] = one;
                        for (byte i = -1; i < 3 + 1; i++) {
                            map[x + i][y + 1] = q;
                            map[x + i][y - 1] = q;
                            try {
                                map[x - 1][y] = q;
                                map[x + 3][y] = q;
                            } catch (ArrayIndexOutOfBoundsException io) {
                            }
                        }
                    } else {
                        generate3Xship();
                    }
                } else {
                    generate3Xship();
                }
            } else {
                generate3Xship();
            }
        } else {
            xAxis = (byte) ((Math.random() * 10) + 1);
            x = xAxis;
            yAxis = (byte) ((Math.random() * 8) + 1);
            y = yAxis;
            if ((map[xAxis][yAxis] == o) & (map[xAxis][yAxis + 2] == o) & (map[xAxis][yAxis + 1] == o)) {
                if ((map[xAxis + 1][yAxis] != one) & (map[xAxis + 1][yAxis + 2] != one) & (map[xAxis + 1][yAxis + 1] != one)) {
                    if ((map[xAxis - 1][yAxis] != one) & (map[xAxis - 1][yAxis + 2] != one) & (map[xAxis - 1][yAxis + 1] != one)) {
                        map[xAxis][yAxis] = one;
                        ++yAxis;
                        map[xAxis][yAxis] = one;
                        ++yAxis;
                        map[xAxis][yAxis] = one;
                        for (byte i = -1; i < 3 + 1; i++) {

                            map[x + 1][y + i] = q;
                            map[x - 1][y + i] = q;
                            try {
                                map[x][y - 1] = q;
                                map[x][y + 3] = q;
                            } catch (ArrayIndexOutOfBoundsException io) {
                            }
                        }
                    } else {
                        generate3Xship();
                    }
                } else {
                    generate3Xship();
                }
            } else {
                generate3Xship();
            }
        }
    }

    public void generate2Xship() {
        byte z = (byte) (Math.random() * 11);
        byte xAxis, x, yAxis, y;
        if (z < 5) {
            xAxis = (byte) ((Math.random() * 9) + 1);
            x = xAxis;
            yAxis = (byte) ((Math.random() * 10) + 1);
            y = yAxis;
            if ((map[xAxis][yAxis] == o) & (map[xAxis + 2][yAxis] == o) & (map[xAxis + 1][yAxis] == o)) {
                if ((map[xAxis][yAxis + 1] != one) & (map[xAxis + 2][yAxis + 1] != one) & (map[xAxis + 1][yAxis + 1] != one)) {
                    if ((map[xAxis][yAxis - 1] != one) & (map[xAxis + 2][yAxis - 1] != one) & (map[xAxis + 2][yAxis - 1] != one)) {
                        map[xAxis][yAxis] = one;
                        ++xAxis;
                        map[xAxis][yAxis] = one;
                        for (byte i = -1; i < 2 + 1; i++) {
                            map[x + i][y + 1] = q;
                            map[x + i][y - 1] = q;
                            map[x - 1][y] = q;
                            map[x + 2][y] = q;
                        }
                    } else {
                        generate2Xship();
                    }
                } else {
                    generate2Xship();
                }
            } else {
                generate2Xship();
            }
        } else {
            xAxis = (byte) ((Math.random() * 10) + 1);
            x = xAxis;
            yAxis = (byte) ((Math.random() * 9) + 1);
            y = yAxis;
            if ((map[xAxis][yAxis] == o) & (map[xAxis][yAxis + 2] == o) & (map[xAxis][yAxis + 2] == o)) {
                if ((map[xAxis + 1][yAxis] != one) & (map[xAxis + 1][yAxis + 2] != one) & (map[xAxis + 1][yAxis + 1] != one)) {
                    if ((map[xAxis - 1][yAxis] != one) & (map[xAxis - 1][yAxis + 2] != one) & (map[xAxis - 1][yAxis + 1] != one)) {
                        map[xAxis][yAxis] = one;
                        ++yAxis;
                        map[xAxis][yAxis] = one;
                        for (byte i = -1; i < 2 + 1; i++) {
                            try {
                                map[x + 1][y + i] = q;
                                map[x - 1][y + i] = q;
                                map[x][y - 1] = q;
                                map[x][y + 2] = q;
                            } catch (ArrayIndexOutOfBoundsException io) {
                            }
                        }
                    } else {
                        generate2Xship();
                    }
                } else {
                    generate2Xship();
                }
            } else {
                generate2Xship();
            }
        }
    }

    public void generate1Xship() {
        byte xAxis, yAxis, x, y;
        byte z = (byte) (Math.random() * 11);
        if (z < 5) {
            xAxis = (byte) ((Math.random() * 10) + 1);
            x = xAxis;
            yAxis = (byte) ((Math.random() * 10) + 1);
            y = yAxis;
            if ((map[xAxis][yAxis] == o) & (map[xAxis + 1][yAxis] == o)) {
                if ((map[xAxis][yAxis + 1] != one) & (map[xAxis + 1][yAxis + 1] != one)) {
                    if ((map[xAxis][yAxis - 1] != one) & (map[xAxis + 1][yAxis - 1] != one)) {
                        map[xAxis][yAxis] = one;
                        for (byte i = -1; i < 1 + 1; i++) {
                            map[x + i][y + 1] = q;
                            map[x + i][y - 1] = q;
                            map[x - 1][y] = q;
                            map[x + 1][y] = q;
                        }
                    } else {
                        generate1Xship();
                    }
                } else {
                    generate1Xship();
                }
            } else {
                generate1Xship();
            }
        } else {

            xAxis = (byte) ((Math.random() * 10) + 1);
            x = xAxis;
            yAxis = (byte) ((Math.random() * 10) + 1);
            y = yAxis;
            if ((map[xAxis][yAxis] == o) & (map[xAxis][yAxis + 1] == o)) {
                if ((map[xAxis + 1][yAxis] != one) & (map[xAxis + 1][yAxis + 1] != one)) {
                    if ((map[xAxis - 1][yAxis] != one) & (map[xAxis - 1][yAxis + 1] != one)) {
                        map[xAxis][yAxis] = one;

                        for (byte i = -1; i < 1 + 1; i++) {
                            try {
                                map[x + 1][y + i] = q;
                                map[x - 1][y + i] = q;
                                map[x][y - 1] = q;
                                map[x][y + 1] = q;
                            } catch (ArrayIndexOutOfBoundsException io) {
                            }
                        }

                    } else {

                        generate1Xship();
                    }
                } else {
                    generate1Xship();
                }
            } else {
                generate1Xship();
            }
        }
    }

    private void clearMapFromQs() {
        for (int i = 0; i < map.length; i++) {
            for (int k = 0; k < map.length; k++) {
                if (map[i][k] == 'q') {
                    map[i][k] = 'o';
                }
            }
        }
    }

}