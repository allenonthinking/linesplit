package com.filesplit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;

public class CheckFile {
	private static int writecount = 0;

	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("args length <2");
			return;
		}
		String inputPath = args[0];

		String inputPathTwo = args[1];
		
		String outPath = args[2];
		
		String outPathTwo = args[3];


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


		long startTime = System.currentTimeMillis();

		System.out.println("inputPath :" + inputPath);

		System.out.println("outPath dir :" + outPath);

		writeAndRead(inputPath, outPath);
		writeUTF(inputPathTwo,outPathTwo);
		// writeAndRead("/tmp/bh5wzzk0_200205_201302211537.txt","/tmp/hb2.txt");
		// writeAndRead("/tmp/bh5wzzk0_200205_201302211537.txt","/tmp/hb1.txt");
		long endTime = System.currentTimeMillis();
		System.out.println("time sec :" + (endTime - startTime) / 1000);
	}

	public static void writeAndRead(String inputfilePath,
			String outputfilePath) {
		String lineCF = ",";
		String lineCN = System.getProperty("line.separator");
		StringBuilder newline = new StringBuilder();
		// 输出计数器
		int rigthcount = 0;
		
		int count = 0;

		// 统计计数器
		int showallcount = 0;
		int showrigthcount = 0;
		int showerrorcount = 0;

		File file = new File(inputfilePath);
		String read;
		FileReader fileread = null;
		BufferedReader bufread = null;
		try {
			fileread = new FileReader(file);
			bufread = new BufferedReader(new InputStreamReader(
					new FileInputStream(file), "ISO8859-1"));
			while ((read = bufread.readLine()) != null) {
				showallcount++;
				if (rigthcount > 1000) {
					writeTxtFile(outputfilePath, newline.toString(), true);
					rigthcount = 0;
					newline = new StringBuilder();
				}
				if (read.length() >= 1626) {
					if(Integer.parseInt(read.substring(263, 275).trim())==170){
						// ZKHPID0 POSITION(1:20) CHAR(20) ,
						newline.append(read);
						newline.append(lineCN);
						count++;
					}
					rigthcount++;
					
					showrigthcount++;

				} else {

					showerrorcount++;
				}
			}
			if (newline != null && newline.toString().length() != 0) {
				writeTxtFile(outputfilePath, newline.toString(), true);
			}
			System.out.println("allcount:" + showallcount);
			System.out.println("rigthcount:" + showrigthcount);
			System.out.println("errorcount:" + showerrorcount);
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
	public static void writeUTF(String inputfilePath,
			String outputfilePath) {
		String lineCF = ",";
		String lineCN = System.getProperty("line.separator");
		StringBuilder newline = new StringBuilder();
		StringBuilder errorline = new StringBuilder();
		// 输出计数器
		int rigthcount = 0;
		int errorcount = 0;
		
		int count = 0;

		// 统计计数器
		int showallcount = 0;
		int showrigthcount = 0;
		int showerrorcount = 0;

		File file = new File(inputfilePath);
		String read;
		FileReader fileread = null;
		BufferedReader bufread = null;
		try {
			fileread = new FileReader(file);
			bufread = new BufferedReader(new InputStreamReader(
					new FileInputStream(file), "UTF-8"));
			while ((read = bufread.readLine()) != null) {
				showallcount++;
				if (rigthcount > 1000) {
					writeTxtFileTwo(outputfilePath, newline.toString(), true);
					rigthcount = 0;
					newline = new StringBuilder();
				}
				if (errorcount > 1000) {
					errorcount = 0;
					errorline = new StringBuilder();
				}
//				if (read.length() >= 1626) {
				String[] lines = read.split(",");
					if(Integer.parseInt(lines[63].trim())==170){
						// ZKHPID0 POSITION(1:20) CHAR(20) ,
						newline.append(read);
						newline.append(lineCN);
						count++;
					}
					rigthcount++;
					
					showrigthcount++;

//				} else {
//					errorcount++;
//
//					showerrorcount++;
//
//					errorline.append(read);
//					errorline.append(lineCN);
//				}
			}
			if (newline != null && newline.toString().length() != 0) {
				writeTxtFileTwo(outputfilePath, newline.toString(), true);
			}
			System.out.println("allcount:" + showallcount);
			System.out.println("rigthcount:" + showrigthcount);
			System.out.println("errorcount:" + showerrorcount);
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
			 randomFile.write(newStr.getBytes("ISO8859-1"));

//			String utf8 = getUTF8StringFromGBKString(new String(
//					newStr.getBytes("ISO-8859-1"), "GBK"));
//			randomFile.write(utf8.getBytes("utf-8"));

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
	public static void writeTxtFileTwo(String filePath, String newStr,
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
			 randomFile.write(newStr.getBytes("utf-8"));

//			String utf8 = getUTF8StringFromGBKString(new String(
//					newStr.getBytes("ISO-8859-1"), "GBK"));
//			randomFile.write(utf8.getBytes("utf-8"));

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
