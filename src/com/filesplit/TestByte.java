package com.filesplit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;

public class TestByte {
	private static int writecount = 0;

	public static void main(String[] args) {
		if (args.length < 3) {
			System.out.println("args length <3");
			return;
		}
		String inputPath = args[0];

		String outPath = args[1];

		String outErrorPath = args[2];

		// 原数据文件检测
		File inputPathFile = new File(inputPath);
		if (!inputPathFile.exists()) {
			System.out.println(inputPathFile + ":no exist");
			return;
		}

		// 目标数据文件目录检测
		File outPathDir = new File(outPath);
		try {
			if (!outPathDir.getParentFile().exists()) {
				System.out.println(outPathDir.getParent() + " :dir  no exist");
				return;
			}

		} catch (Exception e) {
			System.out.println(outPath + " :outPath  error");
			return;
		}

		// 目标错误数据文件目录检测
		File outPathErrorDir = new File(outErrorPath);
		try {
			if (!outPathErrorDir.getParentFile().exists()) {
				System.out.println(outPathErrorDir.getParent()
						+ " :dir  no exist");
				return;
			}

		} catch (Exception e) {
			System.out.println(outPathErrorDir + " :outPath  error");
			return;
		}

		long startTime = System.currentTimeMillis();

		System.out.println("inputPath :" + inputPath);

		System.out.println("outPath dir :" + outPath);

		writeAndRead(inputPath, outPath, outErrorPath);

		// writeAndRead("/tmp/bh5wzzk0_200205_201302211537.txt","/tmp/hb2.txt");
		// writeAndRead("/tmp/bh5wzzk0_200205_201302211537.txt","/tmp/hb1.txt");
		long endTime = System.currentTimeMillis();
		System.out.println("time sec :" + (endTime - startTime) / 1000);
	}

	public static void writeAndRead(String inputfilePath,
			String outputfilePath, String outErrorPath) {
		String lineCF = ",";
		String lineCN = System.getProperty("line.separator");
		StringBuilder newline = new StringBuilder();
		StringBuilder errorline = new StringBuilder();
		// 输出计数器
		int rigthcount = 0;
		int errorcount = 0;

		// 统计计数器
		int showallcount = 0;
		int showrigthcount = 0;
		int showerrorcount = 0;

		File file = new File(inputfilePath);
		String read;
		String oldread =null;
		FileReader fileread = null;
		BufferedReader bufread = null;
		try {
			fileread = new FileReader(file);
			bufread = new BufferedReader(new InputStreamReader(
					new FileInputStream(file), "ISO8859-1"));
			while ((oldread = bufread.readLine()) != null) {
				read = oldread.replace(",", ".");
				showallcount++;
				if (rigthcount > 1000) {
					writeTxtFile(outputfilePath, newline.toString(), true);
					rigthcount = 0;
					newline = new StringBuilder();
				}
				if (errorcount > 1000) {
					writeTxtFile(outErrorPath, errorline.toString(), true);
					errorcount = 0;
					errorline = new StringBuilder();
				}
				if (read.length() >= 1626) {

					// ZKHPID0 POSITION(1:20) CHAR(20) ,
					newline.append(read.substring(0, 20));
					newline.append(lineCF);
					// ZKFPBZ0 POSITION(21:21) CHAR(1) ,
					newline.append(read.substring(20, 21));
					newline.append(lineCF);
					// ZKJYBZ0 POSITION(22:22) CHAR(1) ,
					newline.append(read.substring(21, 22));
					newline.append(lineCF);
					// ZKYSZLB POSITION(23:23) CHAR(1) ,
					newline.append(read.substring(22, 23));
					newline.append(lineCF);
					// ZKPZBZ0 POSITION(24:24) CHAR(1) ,
					newline.append(read.substring(23, 24));
					newline.append(lineCF);
					// ZKHPLX0 POSITION(25:25) CHAR(1) ,
					newline.append(read.substring(24, 25));
					newline.append(lineCF);
					// ZKJHYSH POSITION(26:36) CHAR(11) ,
					newline.append(read.substring(25, 36));
					newline.append(lineCF);
					// ZKHPPF0 POSITION(37:37) CHAR(1) ,
					newline.append(read.substring(36, 37));
					newline.append(lineCF);
					// ZKHPPH0 POSITION(38:43) CHAR(6) ,
					newline.append(read.substring(37, 43));
					newline.append(lineCF);
					// ZKZPRQ0 POSITION(44:51) CHAR(8) ,
					newline.append(read.substring(43, 51));
					newline.append(lineCF);
					// ZKZPSJ0 POSITION(52:55) CHAR(4) ,
					newline.append(read.substring(51, 55));
					newline.append(lineCF);
					// ZKTJRQ0 POSITION(56:63) CHAR(8) ,
					newline.append(read.substring(55, 63));
					newline.append(lineCF);
					// ZKRKRQ0 POSITION(64:71) CHAR(8) ,
					newline.append(read.substring(63, 71));
					newline.append(lineCF);
					// ZKFZDBM POSITION(72:74) CHAR(3) ,
					newline.append(read.substring(71, 74));
					newline.append(lineCF);
					// ZKFZNM0 POSITION(75:79) CHAR(5) ,
					newline.append(read.substring(74, 79));
					newline.append(lineCF);
					// ZKFZHZM POSITION(80:89) CHAR(10) ,
					newline.append(read.substring(79, 89));
					newline.append(lineCF);
					// ZKFZCWD POSITION(90:94) CHAR(5) ,
					newline.append(read.substring(89, 94));
					newline.append(lineCF);
					// ZKFZFJM POSITION(95:99) CHAR(5) ,
					newline.append(read.substring(94, 99));
					newline.append(lineCF);
					// ZKFZLJM POSITION(100:104) CHAR(5) ,
					newline.append(read.substring(99, 104));
					newline.append(lineCF);
					// ZKFZSSM POSITION(105:106) CHAR(2) ,
					newline.append(read.substring(104, 106));
					newline.append(lineCF);
					// ZKFZXLM POSITION(107:116) CHAR(10) ,
					newline.append(read.substring(106, 116));
					newline.append(lineCF);
					// ZKFZYXM POSITION(117:126) CHAR(10) ,
					newline.append(read.substring(116, 126));
					newline.append(lineCF);
					// ZKFZYXL POSITION(127:132) CHAR(6) ,
					newline.append(read.substring(126, 132));
					newline.append(lineCF);
					// ZKZDJY0 POSITION(133:135) CHAR(3) ,
					newline.append(read.substring(132, 135));
					newline.append(lineCF);
					// ZKZDJY1 POSITION(136:138) CHAR(3) ,
					newline.append(read.substring(135, 138));
					newline.append(lineCF);
					// ZKZDJY2 POSITION(139:141) CHAR(3) ,
					newline.append(read.substring(138, 141));
					newline.append(lineCF);
					// ZKZDJY3 POSITION(142:144) CHAR(3) ,
					newline.append(read.substring(141, 144));
					newline.append(lineCF);
					// ZKZDJY4 POSITION(145:147) CHAR(3) ,
					newline.append(read.substring(144, 147));
					newline.append(lineCF);
					// ZKZDJY5 POSITION(148:150) CHAR(3) ,
					newline.append(read.substring(147, 150));
					newline.append(lineCF);
					// ZKZDJY6 POSITION(151:153) CHAR(3) ,
					newline.append(read.substring(150, 153));
					newline.append(lineCF);
					// ZKZDJY7 POSITION(154:156) CHAR(3) ,
					newline.append(read.substring(153, 156));
					newline.append(lineCF);
					// ZKZDJY8 POSITION(157:159) CHAR(3) ,
					newline.append(read.substring(156, 159));
					newline.append(lineCF);
					// ZKZDJY9 POSITION(160:162) CHAR(3) ,
					newline.append(read.substring(159, 162));
					newline.append(lineCF);
					// ZKXZKM0 POSITION(163:165) CHAR(3) ,
					newline.append(read.substring(162, 165));
					newline.append(lineCF);
					// ZKXZSX0 POSITION(166:166) CHAR(1) ,
					newline.append(read.substring(165, 166));
					newline.append(lineCF);
					// ZKXZKM1 POSITION(167:169) CHAR(3) ,
					newline.append(read.substring(166, 169));
					newline.append(lineCF);
					// ZKXZSX1 POSITION(170:170) CHAR(1) ,
					newline.append(read.substring(169, 170));
					newline.append(lineCF);
					// ZKXZKM2 POSITION(171:173) CHAR(3) ,
					newline.append(read.substring(170, 173));
					newline.append(lineCF);
					// ZKXZSX2 POSITION(174:174) CHAR(1) ,
					newline.append(read.substring(173, 174));
					newline.append(lineCF);
					// ZKXZKM3 POSITION(175:177) CHAR(3) ,
					newline.append(read.substring(174, 177));
					newline.append(lineCF);
					// ZKXZSX3 POSITION(178:178) CHAR(1) ,
					newline.append(read.substring(177, 178));
					newline.append(lineCF);
					// ZKXZKM4 POSITION(179:181) CHAR(3) ,
					newline.append(read.substring(178, 181));
					newline.append(lineCF);
					// ZKXZSX4 POSITION(182:182) CHAR(1) ,
					newline.append(read.substring(181, 182));
					newline.append(lineCF);
					// ZKXZKM5 POSITION(183:185) CHAR(3) ,
					newline.append(read.substring(182, 185));
					newline.append(lineCF);
					// ZKXZSX5 POSITION(186:186) CHAR(1) ,
					newline.append(read.substring(185, 186));
					newline.append(lineCF);
					// ZKXZKM6 POSITION(187:189) CHAR(3) ,
					newline.append(read.substring(186, 189));
					newline.append(lineCF);
					// ZKXZSX6 POSITION(190:190) CHAR(1) ,
					newline.append(read.substring(189, 190));
					newline.append(lineCF);
					// ZKXZKM7 POSITION(191:193) CHAR(3) ,
					newline.append(read.substring(190, 193));
					newline.append(lineCF);
					// ZKXZSX7 POSITION(194:194) CHAR(1) ,
					newline.append(read.substring(193, 194));
					newline.append(lineCF);
					// ZKXZKM8 POSITION(195:197) CHAR(3) ,
					newline.append(read.substring(194, 197));
					newline.append(lineCF);
					// ZKXZSX8 POSITION(198:198) CHAR(1) ,
					newline.append(read.substring(197, 198));
					newline.append(lineCF);
					// ZKXZKM9 POSITION(199:201) CHAR(3) ,
					newline.append(read.substring(198, 201));
					newline.append(lineCF);
					// ZKXZSX9 POSITION(202:202) CHAR(1) ,
					newline.append(read.substring(201, 202));
					newline.append(lineCF);
					// ZKDZDBM POSITION(203:205) CHAR(3) ,
					newline.append(read.substring(202, 205));
					newline.append(lineCF);
					// ZKDZNM0 POSITION(206:210) CHAR(5) ,
					newline.append(read.substring(205, 210));
					newline.append(lineCF);
					// ZKDZHZM POSITION(211:220) CHAR(10) ,
					newline.append(read.substring(210, 220));
					newline.append(lineCF);
					// ZKDZCWD POSITION(221:225) CHAR(5) ,
					newline.append(read.substring(220, 225));
					newline.append(lineCF);
					// ZKDZFJM POSITION(226:230) CHAR(5) ,
					newline.append(read.substring(225, 230));
					newline.append(lineCF);
					// ZKDZLJM POSITION(231:235) CHAR(5) ,
					newline.append(read.substring(230, 235));
					newline.append(lineCF);
					// ZKDZSSM POSITION(236:237) CHAR(2) ,
					newline.append(read.substring(235, 237));
					newline.append(lineCF);
					// ZKDZXLM POSITION(238:247) CHAR(10) ,
					newline.append(read.substring(237, 247));
					newline.append(lineCF);
					// ZKDZYXM POSITION(248:257) CHAR(10) ,
					newline.append(read.substring(247, 257));
					newline.append(lineCF);
					// ZKDZYXL POSITION(258:263) CHAR(6) ,
					newline.append(read.substring(257, 263));
					newline.append(lineCF);
					// ZKZLC00 POSITION(264:275) CHAR(12) ,
					newline.append(read.substring(263, 275));
					newline.append(lineCF);
					// ZKJFLC0 POSITION(276:287) CHAR(12) ,
					newline.append(read.substring(275, 287));
					newline.append(lineCF);
					// ZKJPLC0 POSITION(288:299) CHAR(12) ,
					newline.append(read.substring(287, 299));
					newline.append(lineCF);
					// ZKJJLC0 POSITION(300:311) CHAR(12) ,
					newline.append(read.substring(299, 311));
					newline.append(lineCF);
					// ZKFHRDM POSITION(312:320) CHAR(9) ,
					newline.append(read.substring(311, 320));
					newline.append(lineCF);
					// ZKFHRMC POSITION(321:390) CHAR(70) ,
					newline.append(read.substring(320, 390));
					newline.append(lineCF);
					// ZKFHRDH POSITION(391:404) CHAR(14) ,
					newline.append(read.substring(390, 404));
					newline.append(lineCF);
					// ZKFHRYB POSITION(405:410) CHAR(6) ,
					newline.append(read.substring(404, 410));
					newline.append(lineCF);
					// ZKSHRDM POSITION(411:419) CHAR(9) ,
					newline.append(read.substring(410, 419));
					newline.append(lineCF);
					// ZKSHRMC POSITION(420:489) CHAR(70) ,
					newline.append(read.substring(419, 489));
					newline.append(lineCF);
					// ZKSHRDH POSITION(490:503) CHAR(14) ,
					newline.append(read.substring(489, 503));
					newline.append(lineCF);
					// ZKSHRYB POSITION(504:509) CHAR(6) ,
					newline.append(read.substring(503, 509));
					newline.append(lineCF);
					// ZKYDQX0 POSITION(510:515) CHAR(6) ,
					newline.append(read.substring(509, 515));
					newline.append(lineCF);
					// ZKYDDRQ POSITION(516:523) CHAR(8) ,
					newline.append(read.substring(515, 523));
					newline.append(lineCF);
					// ZKCZBZ0 POSITION(524:526) CHAR(3) ,
					newline.append(read.substring(523, 526));
					newline.append(lineCF);
					// ZKZCH00 POSITION(527:534) CHAR(8) ,
					newline.append(read.substring(526, 534));
					newline.append(lineCF);
					// ZKCSXS0 POSITION(535:544) CHAR(10) ,
					newline.append(read.substring(534, 544));
					newline.append(lineCF);
					// ZKZCBZ0 POSITION(545:556) CHAR(12) ,
					newline.append(read.substring(544, 556));
					newline.append(lineCF);
					// ZKZZL00 POSITION(557:573) CHAR(17) ,
					newline.append(read.substring(556, 573));
					newline.append(lineCF);
					// ZKCXJZX POSITION(574:581) CHAR(8) ,
					newline.append(read.substring(573, 581));
					newline.append(lineCF);
					// ZKSFPBS POSITION(582:591) CHAR(10) ,
					newline.append(read.substring(581, 591));
					newline.append(lineCF);
					// ZKSFB00 POSITION(592:592) CHAR(1) ,
					newline.append(read.substring(591, 592));
					newline.append(lineCF);
					// ZKPBB00 POSITION(593:593) CHAR(1) ,
					newline.append(read.substring(592, 593));
					newline.append(lineCF);
					// ZKZCB00 POSITION(594:594) CHAR(1) ,
					newline.append(read.substring(593, 594));
					newline.append(lineCF);
					// ZKZPL00 POSITION(595:596) CHAR(2) ,
					newline.append(read.substring(594, 596));
					newline.append(lineCF);
					// ZKPMGS0 POSITION(597:600) CHAR(4) ,
					newline.append(read.substring(596, 600));
					newline.append(lineCF);
					// ZKPMDM0 POSITION(601:607) CHAR(7) ,
					newline.append(read.substring(600, 607));
					newline.append(lineCF);
					// ZKPMHZ0 POSITION(608:627) CHAR(20) ,
					newline.append(read.substring(607, 627));
					newline.append(lineCF);
					// ZKJSHU0 POSITION(628:635) CHAR(8) ,
					newline.append(read.substring(627, 635));
					newline.append(lineCF);
					// ZKLDTJ0 POSITION(636:643) CHAR(8) ,
					newline.append(read.substring(635, 643));
					newline.append(lineCF);
					// ZKBZH00 POSITION(644:653) CHAR(10) ,
					newline.append(read.substring(643, 653));
					newline.append(lineCF);
					// ZKYJH00 POSITION(654:657) CHAR(4) ,
					newline.append(read.substring(653, 657));
					newline.append(lineCF);
					// ZKYJL00 POSITION(658:667) CHAR(10) ,
					newline.append(read.substring(657, 667));
					newline.append(lineCF);
					// ZKJJC00 POSITION(668:673) CHAR(6) ,
					newline.append(read.substring(667, 673));
					newline.append(lineCF);
					// ZKSMZL0 POSITION(674:690) CHAR(17) ,
					newline.append(read.substring(673, 690));
					newline.append(lineCF);
					// ZKTLCZ0 POSITION(691:707) CHAR(17) ,
					newline.append(read.substring(690, 707));
					newline.append(lineCF);
					// ZKJFZL0 POSITION(708:724) CHAR(17) ,
					newline.append(read.substring(707, 724));
					newline.append(lineCF);
					// ZKBJJE0 POSITION(725:741) CHAR(17) ,
					newline.append(read.substring(724, 741));
					newline.append(lineCF);
					// ZKBJFL0 POSITION(742:747) CHAR(6) ,
					newline.append(read.substring(741, 747));
					newline.append(lineCF);
					// ZKBXJE0 POSITION(748:764) CHAR(17) ,
					newline.append(read.substring(747, 764));
					newline.append(lineCF);
					// ZKBXFL0 POSITION(765:770) CHAR(6) ,
					newline.append(read.substring(764, 770));
					newline.append(lineCF);
					// ZKWPDM0 POSITION(771:776) CHAR(6) ,
					newline.append(read.substring(770, 776));
					newline.append(lineCF);
					// ZKJF001 POSITION(777:793) CHAR(17) ,
					newline.append(read.substring(776, 793));
					newline.append(lineCF);
					// ZKJF002 POSITION(794:810) CHAR(17) ,
					newline.append(read.substring(793, 810));
					newline.append(lineCF);
					// ZKJF003 POSITION(811:827) CHAR(17) ,
					newline.append(read.substring(810, 827));
					newline.append(lineCF);
					// ZKJF004 POSITION(828:844) CHAR(17) ,
					newline.append(read.substring(827, 844));
					newline.append(lineCF);
					// ZKJF005 POSITION(845:861) CHAR(17) ,
					newline.append(read.substring(844, 861));
					newline.append(lineCF);
					// ZKJF006 POSITION(862:878) CHAR(17) ,
					newline.append(read.substring(861, 878));
					newline.append(lineCF);
					// ZKJF007 POSITION(879:895) CHAR(17) ,
					newline.append(read.substring(878, 895));
					newline.append(lineCF);
					// ZKJF008 POSITION(896:912) CHAR(17) ,
					newline.append(read.substring(895, 912));
					newline.append(lineCF);
					// ZKJF009 POSITION(913:929) CHAR(17) ,
					newline.append(read.substring(912, 929));
					newline.append(lineCF);
					// ZKJF010 POSITION(930:946) CHAR(17) ,
					newline.append(read.substring(929, 946));
					newline.append(lineCF);
					// ZKJF011 POSITION(947:963) CHAR(17) ,
					newline.append(read.substring(946, 963));
					newline.append(lineCF);
					// ZKJF012 POSITION(964:980) CHAR(17) ,
					newline.append(read.substring(963, 980));
					newline.append(lineCF);
					// ZKJF013 POSITION(981:997) CHAR(17) ,
					newline.append(read.substring(980, 997));
					newline.append(lineCF);
					// ZKJF014 POSITION(998:1014) CHAR(17) ,
					newline.append(read.substring(997, 1014));
					newline.append(lineCF);
					// ZKJF015 POSITION(1015:1031) CHAR(17) ,
					newline.append(read.substring(1014, 1031));
					newline.append(lineCF);
					// ZKZPRXM POSITION(1032:1041) CHAR(10) ,
					newline.append(read.substring(1031, 1041));
					newline.append(lineCF);
					// ZKBGBJ0 POSITION(1042:1042) CHAR(1) ,
					newline.append(read.substring(1041, 1042));
					newline.append(lineCF);
					// ZKJXTCZ POSITION(1043:1047) CHAR(5) ,
					newline.append(read.substring(1042, 1047));
					newline.append(lineCF);
					// ZKXXDRQ POSITION(1048:1055) CHAR(8) ,
					newline.append(read.substring(1047, 1055));
					newline.append(lineCF);
					// ZKDDRQ0 POSITION(1056:1063) CHAR(8) ,
					newline.append(read.substring(1055, 1063));
					newline.append(lineCF);
					// ZKJFRQ0 POSITION(1064:1071) CHAR(8) ,
					newline.append(read.substring(1063, 1071));
					newline.append(lineCF);
					// ZKJBRXM POSITION(1072:1081) CHAR(10) ,
					newline.append(read.substring(1071, 1081));
					newline.append(lineCF);
					// ZKDZSHR POSITION(1082:1091) CHAR(10) ,
					newline.append(read.substring(1081, 1091));
					newline.append(lineCF);
					// ZKLHRID POSITION(1092:1109) CHAR(18) ,
					newline.append(read.substring(1091, 1109));
					newline.append(lineCF);
					// ZKJSBZ0 POSITION(1110:1110) CHAR(1) ,
					newline.append(read.substring(1109, 1110));
					newline.append(lineCF);
					// ZKJSXFB POSITION(1111:1111) CHAR(1) ,
					newline.append(read.substring(1110, 1111));
					newline.append(lineCF);
					// ZKTJLCB POSITION(1112:1115) CHAR(4) ,
					newline.append(read.substring(1111, 1115));
					newline.append(lineCF);
					// ZKHPBBH POSITION(1116:1135) CHAR(20) ,
					newline.append(read.substring(1115, 1135));
					newline.append(lineCF);
					// ZKBYBZ1 POSITION(1136:1136) CHAR(1) ,
					newline.append(read.substring(1135, 1136));
					newline.append(lineCF);
					// ZKBYBZ2 POSITION(1137:1139) CHAR(3) ,
					newline.append(read.substring(1136, 1139));
					newline.append(lineCF);
					// ZKBYBZ3 POSITION(1140:1144) CHAR(5) ,
					newline.append(read.substring(1139, 1144));
					newline.append(lineCF);
					// ZKBYBZ4 POSITION(1145:1154) CHAR(10) ,
					newline.append(read.substring(1144, 1154));
					newline.append(lineCF);
					// ZKBYBZ5 POSITION(1155:1174) CHAR(20) ,
					newline.append(read.substring(1154, 1174));
					newline.append(lineCF);
					// ZKRKSF0 POSITION(1175:1178) CHAR(4) ,
					newline.append(read.substring(1174, 1178));
					newline.append(lineCF);
					// ZKJFBBH POSITION(1179:1184) CHAR(6) ,
					newline.append(read.substring(1178, 1184));
					newline.append(lineCF);
					// ZKYKJBB POSITION(1185:1190) CHAR(6) ,
					newline.append(read.substring(1184, 1190));
					newline.append(lineCF);
					// ZKQTBB1 POSITION(1191:1198) CHAR(8) ,
					newline.append(read.substring(1190, 1198));
					newline.append(lineCF);
					// ZKQTBB2 POSITION(1199:1206) CHAR(8) ,
					newline.append(read.substring(1198, 1206));
					newline.append(lineCF);
					// ZKHPSRL POSITION(1207:1207) CHAR(1) ,
					newline.append(read.substring(1206, 1207));
					newline.append(lineCF);
					// ZKCYRM0 POSITION(1208:1217) CHAR(10) ,
					newline.append(read.substring(1207, 1217));
					newline.append(lineCF);
					// ZKYSRM0 POSITION(1218:1227) CHAR(10) ,
					newline.append(read.substring(1217, 1227));
					newline.append(lineCF);
					// ZKYYRM0 POSITION(1228:1237) CHAR(10) ,
					newline.append(read.substring(1227, 1237));
					newline.append(lineCF);
					// ZKYYRS0 POSITION(1238:1241) CHAR(4) ,
					newline.append(read.substring(1237, 1241));
					newline.append(lineCF);
					// ZKZZZH0 POSITION(1242:1261) CHAR(20) ,
					newline.append(read.substring(1241, 1261));
					newline.append(lineCF);
					// ZKSZMM0 POSITION(1262:1267) CHAR(6) ,
					newline.append(read.substring(1261, 1267));
					newline.append(lineCF);
					// ZKZPJM0 POSITION(1268:1269) CHAR(2) ,
					newline.append(read.substring(1267, 1269));
					newline.append(lineCF);
					// ZKZPKH0 POSITION(1270:1289) CHAR(20) ,
					newline.append(read.substring(1269, 1289));
					newline.append(lineCF);
					// ZKBBBZ0 POSITION(1290:1290) CHAR(1) ,
					newline.append(read.substring(1289, 1290));
					newline.append(lineCF);
					// ZKBYZD0 POSITION(1291:1310) CHAR(20) ,
					newline.append(read.substring(1290, 1310));
					newline.append(lineCF);
					// ZKBYZD1 POSITION(1311:1330) CHAR(20) ,
					newline.append(read.substring(1310, 1330));
					newline.append(lineCF);
					// ZKBYZD2 POSITION(1331:1350) CHAR(20) ,
					newline.append(read.substring(1330, 1350));
					newline.append(lineCF);
					// ZKBYZD3 POSITION(1351:1370) CHAR(20) ,
					newline.append(read.substring(1350, 1370));
					newline.append(lineCF);
					// ZKBYZD4 POSITION(1371:1390) CHAR(20) ,
					newline.append(read.substring(1370, 1390));
					newline.append(lineCF);
					// ZKBYZD5 POSITION(1391:1410) CHAR(20) ,
					newline.append(read.substring(1390, 1410));
					newline.append(lineCF);
					// ZKBYZD6 POSITION(1411:1430) CHAR(20) ,
					newline.append(read.substring(1410, 1430));
					newline.append(lineCF);
					// ZKBYZD7 POSITION(1431:1450) CHAR(20) ,
					newline.append(read.substring(1430, 1450));
					newline.append(lineCF);
					// ZKBYZD8 POSITION(1451:1470) CHAR(20) ,
					newline.append(read.substring(1450, 1470));
					newline.append(lineCF);
					// ZKBYZD9 POSITION(1471:1490) CHAR(20) ,
					newline.append(read.substring(1470, 1490));
					newline.append(lineCF);
					// ZKHPLX2 POSITION(1491:1492) CHAR(2) ,
					newline.append(read.substring(1490, 1492));
					newline.append(lineCF);
					// ZKZMBBH POSITION(1493:1498) CHAR(6) ,
					newline.append(read.substring(1492, 1498));
					newline.append(lineCF);
					// ZKPMBBH POSITION(1499:1504) CHAR(6) ,
					newline.append(read.substring(1498, 1504));
					newline.append(lineCF);
					// ZKZPZDM POSITION(1505:1507) CHAR(3) ,
					newline.append(read.substring(1504, 1507));
					newline.append(lineCF);
					// ZKZPZMC POSITION(1508:1517) CHAR(10) ,
					newline.append(read.substring(1507, 1517));
					newline.append(lineCF);
					// ZKHPSBM POSITION(1518:1533) CHAR(16) ,
					newline.append(read.substring(1517, 1533));
					newline.append(lineCF);
					// ZKYDFFH POSITION(1534:1544) CHAR(11) ,
					newline.append(read.substring(1533, 1544));
					newline.append(lineCF);
					// ZKJYJB0 POSITION(1545:1545) CHAR(1) ,
					newline.append(read.substring(1544, 1545));
					newline.append(lineCF);
					// ZKCJRXM POSITION(1546:1555) CHAR(10) ,
					newline.append(read.substring(1545, 1555));
					newline.append(lineCF);
					// ZKBWCBZ POSITION(1556:1556) CHAR(1) ,
					newline.append(read.substring(1555, 1556));
					newline.append(lineCF);
					// ZKYCCS0 POSITION(1557:1559) CHAR(3) ,
					newline.append(read.substring(1556, 1559));
					newline.append(lineCF);
					// ZKFZYXH POSITION(1560:1569) CHAR(10) ,
					newline.append(read.substring(1559, 1569));
					newline.append(lineCF);
					// ZKTZXDM POSITION(1570:1575) CHAR(6) ,
					newline.append(read.substring(1569, 1575));
					newline.append(lineCF);
					// ZKZJJ10 POSITION(1576:1583) CHAR(8) ,
					newline.append(read.substring(1575, 1583));
					newline.append(lineCF);
					// ZKZJJ20 POSITION(1584:1591) CHAR(8) ,
					newline.append(read.substring(1583, 1591));
					newline.append(lineCF);
					// ZKZFDBL POSITION(1592:1597) CHAR(6) ,
					newline.append(read.substring(1591, 1597));
					newline.append(lineCF);
					// ZKZJJC2 POSITION(1598:1603) CHAR(6) ,
					newline.append(read.substring(1597, 1603));
					newline.append(lineCF);
					// ZKZXXZ0 POSITION(1604:1604) CHAR(1) ,
					newline.append(read.substring(1603, 1604));
					newline.append(lineCF);
					// ZKRJXXH POSITION(1605:1624) CHAR(20) ,
					newline.append(read.substring(1604, 1624));
					newline.append(lineCF);
					// ZKDTCHB POSITION(1625:1625) CHAR(1) ,
					newline.append(read.substring(1624, 1625));
					newline.append(lineCF);
					// ZKZLBZ0 POSITION(1626:1626) CHAR(1)
					newline.append(read.substring(1625));
					newline.append(lineCN);

					rigthcount++;

					showrigthcount++;

				} else {
					errorcount++;

					showerrorcount++;

					errorline.append(read);
					errorline.append(lineCN);
				}
			}
			if (newline != null && newline.toString().length() != 0) {
				writeTxtFile(outputfilePath, newline.toString(), true);
			}
			if (errorline != null && errorline.toString().length() != 0) {
				writeTxtFile(outErrorPath, errorline.toString(), true);
			}
			System.out.println("allcount:" + showallcount);
			System.out.println("rigthcount:" + showrigthcount);
			System.out.println("errorcount:" + showerrorcount);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("read file fail ");
		} finally {
			if (bufread != null) {
				try {
					bufread.close();
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("close bufread fail ");
				}
			}
			if (fileread != null) {
				try {
					fileread.close();
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("close file fail ");
				}
			}
		}
	}

	/**
	 * 写文件.
	 * 
	 * @param newStr
	 *            写入内容
	 * @param isAppened
	 *            true表示追加，false表示覆盖
	 * @throws IOException
	 */
	public static void writeTxtFile(String filePath, String newStr,
			boolean isAppened) throws IOException {
		RandomAccessFile randomFile = null;
		File file = new File(filePath);
		try {
			randomFile = new RandomAccessFile(file, "rw");
			if (isAppened) {
				long fileLength = randomFile.length();
				// 将写文件指针移到文件尾
				randomFile.seek(fileLength);
			}
			// randomFile.write(newStr.getBytes("ISO8859-1"));

			String utf8 = getUTF8StringFromGBKString(new String(
					newStr.getBytes("ISO-8859-1"), "GBK"));
			randomFile.write(utf8.getBytes("utf-8"));

			writecount++;
			if (writecount % 100 == 0) {
				System.out.println("write success:" + (writecount * 1000)
						+ " row");
			}
		} catch (Exception e1) {
			System.out.println("write"+(writecount * 1000)+ " row file fail ");
			e1.printStackTrace();
		} finally {
			if (randomFile != null) {
				try {
					randomFile.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}

	public static String getUTF8StringFromGBKString(String gbkStr) {
		try {
			return new String(getUTF8BytesFromGBKString(gbkStr), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new InternalError();
		}
	}

	public static byte[] getUTF8BytesFromGBKString(String gbkStr) {
		int n = gbkStr.length();
		byte[] utfBytes = new byte[3 * n];
		int k = 0;
		for (int i = 0; i < n; i++) {
			int m = gbkStr.charAt(i);
			if (m < 128 && m >= 0) {
				utfBytes[k++] = (byte) m;
				continue;
			}
			utfBytes[k++] = (byte) (0xe0 | (m >> 12));
			utfBytes[k++] = (byte) (0x80 | ((m >> 6) & 0x3f));
			utfBytes[k++] = (byte) (0x80 | (m & 0x3f));
		}
		if (k < utfBytes.length) {
			byte[] tmp = new byte[k];
			System.arraycopy(utfBytes, 0, tmp, 0, k);
			return tmp;
		}
		return utfBytes;
	}
}
