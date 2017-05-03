public class BowlingGame {

    public int getBowlingScore(String bowlingCode) {
		String ss[];
		int sum = 0;
    	ss = bowlingCode.split("\\|");
		if (ss.length>10) {
			ss[10]=ss[11];
		}
		for (int i = 0; i < 10; i++) {
			if (ss[i].length() == 1) {
				if (ss[i].equals("X")) {
					sum+=10;
					if (i < 9) {
						if (ss[i+1].length() == 1) {
							sum+=10;
							if(i < 8){
								if(ss[i+2].length() == 1) {
									sum+=10;
								}
								else if (ss[i+2].length() == 2) {
									if (ss[i+2].substring(1,2).equals("/")) {
										sum += 10;
									} else if (ss[i+2].substring(1,2).equals("-")) {
										sum += Integer.parseInt(ss[i+2].substring(0,1));
									} else if (ss[i+2].substring(0,1).equals("-")) {
										sum += Integer.parseInt(ss[i+2].substring(1,2));
									} 
								}
							}
							else if (i == 8) {
								if (ss[i+2].substring(0,1).equals("X")) {
									sum += 10;
								} else {
									sum += Integer.parseInt(ss[i+2].substring(0,1));
								}
							}
						}
						else if (ss[i+1].length() == 2) {
							if (ss[i+1].substring(1,2).equals("/")) {
								sum += 10;
							} else if (ss[i+1].substring(1,2).equals("-")) {
								sum += Integer.parseInt(ss[i+1].substring(0,1));
							} else if (ss[i+1].substring(0,1).equals("-")) {
								sum += Integer.parseInt(ss[i+1].substring(1,2));
							}
						}
					}
					else if (i == 9) {
						if (ss[i+1].substring(0,1).equals("X")) {
							sum += 10;
							if (ss[i+1].substring(1,2).equals("X")) {
								sum += 10;
							} else {
								sum += Integer.parseInt(ss[i+1].substring(1,2));
							}
						} else {
							sum += Integer.parseInt(ss[i+1].substring(0,1));

							if (ss[i+1].substring(1,2).equals("X")) {
								sum += 10;
							} else {
								sum += Integer.parseInt(ss[i+1].substring(1,2));
							}
						}
					}
				}
			}
			else if (ss[i].length() == 2) {
				if (ss[i].substring(1,2).equals("/")) {
					sum+=10;
					if (ss[i+1].length() == 1) {
						if (ss[i+1].equals("X")) {
							sum += 10;
						}
						else {
							sum += Integer.parseInt(ss[i+1]);
						}
					}
					else if (ss[i+1].length() == 2) {
						if (!ss[i+1].substring(0,1).equals("-")) {
							sum += Integer.parseInt(ss[i+1].substring(0,1));
						}
					}
				} else if (ss[i].substring(1,2).equals("-")) {
					sum += Integer.parseInt(ss[i].substring(0,1));
				} else if (ss[i].substring(0,1).equals("-")) {
					sum += Integer.parseInt(ss[i].substring(1,2));
				}
				
			}
		}
        return sum;
    }
}
