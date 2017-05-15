import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

//             |************|
//             |*0 **1 **2 *|
//             |************|
//             |*3 **4 **5 *|
//             |************|
//             |*6 **7 **8 *|
//             |************|
// ************|************|************|************
// *36**37**38*|*18**19**20*|*9 **10**11*|*45**46**47*
// ************|************|************|************
// *39**40**41*|*21**22**23*|*12**13**14*|*48**49**50*
// ************|************|************|************
// *42**43**44*|*24**25**26*|*15**16**17*|*51**52**53*
// ************|************|************|************
//             |************|
//             |*27**28**29*|
//             |************|
//             |*30**31**32*|
//             |************|
//             |*33**34**35*|
//             |************|

public class RubiksCubeScramble {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		byte[] cubestate = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1 ,1 , 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5};
		rotateFace(cubestate, 1, 1);
		randomMoves(cubestate, 100);
		System.out.println(getSolveAlgorithm(cubestate));
		
	}
	
	/** Turns the face of the rubiks cube
	 * @param cubestate a length 54 byte array containing the state of the cube
	 * @param face which face to rotate 0=U, 1=R, 2=F, 3=D, 4=L, 5=B
	 * @param n turn face n times clockwise
	 */
	public static void rotateFace(byte[] cubestate, int face, int n) {
		byte tmp = 0;
		switch(face) {
		case 0:
			//Corners of U
			tmp = cubestate[0];
			cubestate[0] = cubestate[6];
			cubestate[6] = cubestate[8];
			cubestate[8] = cubestate[2];
			cubestate[2] = tmp;
			//Edges of U
			tmp = cubestate[1];
			cubestate[1] = cubestate[3];
			cubestate[3] = cubestate[7];
			cubestate[7] = cubestate[5];
			cubestate[5] = tmp;
			//Left corners of top layer
			tmp = cubestate[9];
			cubestate[9] = cubestate[45];
			cubestate[45] = cubestate[36];
			cubestate[36] = cubestate[18];
			cubestate[18] = tmp;
			//Right corners of top layer
			tmp = cubestate[11];
			cubestate[11] = cubestate[47];
			cubestate[47] = cubestate[38];
			cubestate[38] = cubestate[20];
			cubestate[20] = tmp;
			//Edges of top layer
			tmp = cubestate[10];
			cubestate[10] = cubestate[46];
			cubestate[46] = cubestate[37];
			cubestate[37] = cubestate[19];
			cubestate[19] = tmp;
			break;

		case 1:
			//Corners of R
			tmp = cubestate[9];
			cubestate[9] = cubestate[15];
			cubestate[15] = cubestate[17];
			cubestate[17] = cubestate[11];
			cubestate[11] = tmp;
			//Edges of R
			tmp = cubestate[10];
			cubestate[10] = cubestate[12];
			cubestate[12] = cubestate[16];
			cubestate[16] = cubestate[14];
			cubestate[14] = tmp;
			//Left corners of right layer
			tmp = cubestate[2];
			cubestate[2] = cubestate[20];
			cubestate[20] = cubestate[29];
			cubestate[29] = cubestate[51];
			cubestate[51] = tmp;
			//Right corners of right layer
			tmp = cubestate[8];
			cubestate[8] = cubestate[26];
			cubestate[26] = cubestate[35];
			cubestate[35] = cubestate[45];
			cubestate[45] = tmp;
			//Edges of right layer
			tmp = cubestate[5];
			cubestate[5] = cubestate[23];
			cubestate[23] = cubestate[32];
			cubestate[32] = cubestate[48];
			cubestate[48] = tmp;
			break;

		case 2:
			//Corners of F
			tmp = cubestate[18];
			cubestate[18] = cubestate[24];
			cubestate[24] = cubestate[26];
			cubestate[26] = cubestate[20];
			cubestate[20] = tmp;
			//Edges of F
			tmp = cubestate[19];
			cubestate[19] = cubestate[21];
			cubestate[21] = cubestate[25];
			cubestate[25] = cubestate[23];
			cubestate[23] = tmp;
			//Left corners of front layer
			tmp = cubestate[8];
			cubestate[8] = cubestate[38];
			cubestate[38] = cubestate[27];
			cubestate[27] = cubestate[15];
			cubestate[15] = tmp;
			//Right corners of front layer
			tmp = cubestate[6];
			cubestate[6] = cubestate[44];
			cubestate[44] = cubestate[29];
			cubestate[29] = cubestate[9];
			cubestate[9] = tmp;
			//Edges of right layer
			tmp = cubestate[7];
			cubestate[7] = cubestate[41];
			cubestate[41] = cubestate[28];
			cubestate[28] = cubestate[12];
			cubestate[12] = tmp;
			break;

		case 3:
			//Corners of D
			tmp = cubestate[27];
			cubestate[27] = cubestate[33];
			cubestate[33] = cubestate[35];
			cubestate[35] = cubestate[29];
			cubestate[29] = tmp;
			//Edges of F
			tmp = cubestate[28];
			cubestate[28] = cubestate[30];
			cubestate[30] = cubestate[34];
			cubestate[34] = cubestate[32];
			cubestate[32] = tmp;
			//Left corners of down layer
			tmp = cubestate[17];
			cubestate[17] = cubestate[26];
			cubestate[26] = cubestate[44];
			cubestate[44] = cubestate[53];
			cubestate[53] = tmp;
			//Right corners of down layer
			tmp = cubestate[15];
			cubestate[15] = cubestate[24];
			cubestate[24] = cubestate[42];
			cubestate[42] = cubestate[51];
			cubestate[51] = tmp;
			//Edges of right layer
			tmp = cubestate[16];
			cubestate[16] = cubestate[25];
			cubestate[25] = cubestate[43];
			cubestate[43] = cubestate[52];
			cubestate[52] = tmp;
			break;

		case 4:
			//Corners of L
			tmp = cubestate[36];
			cubestate[36] = cubestate[42];
			cubestate[42] = cubestate[44];
			cubestate[44] = cubestate[38];
			cubestate[38] = tmp;
			//Edges of L
			tmp = cubestate[37];
			cubestate[37] = cubestate[39];
			cubestate[39] = cubestate[43];
			cubestate[43] = cubestate[41];
			cubestate[41] = tmp;
			//Left corners of left layer
			tmp = cubestate[6];
			cubestate[6] = cubestate[47];
			cubestate[47] = cubestate[33];
			cubestate[33] = cubestate[24];
			cubestate[24] = tmp;
			//Right corners of left layer
			tmp = cubestate[0];
			cubestate[0] = cubestate[53];
			cubestate[53] = cubestate[27];
			cubestate[27] = cubestate[18];
			cubestate[18] = tmp;
			//Edges of left layer
			tmp = cubestate[3];
			cubestate[3] = cubestate[50];
			cubestate[50] = cubestate[30];
			cubestate[30] = cubestate[21];
			cubestate[21] = tmp;
			break;

		case 5:
			//Corners of B
			tmp = cubestate[45];
			cubestate[45] = cubestate[51];
			cubestate[51] = cubestate[53];
			cubestate[53] = cubestate[47];
			cubestate[47] = tmp;
			//Edges of B
			tmp = cubestate[46];
			cubestate[46] = cubestate[48];
			cubestate[48] = cubestate[52];
			cubestate[52] = cubestate[50];
			cubestate[50] = tmp;
			//Left corners of back layer
			tmp = cubestate[0];
			cubestate[0] = cubestate[11];
			cubestate[11] = cubestate[35];
			cubestate[35] = cubestate[42];
			cubestate[42] = tmp;
			//Right corners of back layer
			tmp = cubestate[2];
			cubestate[2] = cubestate[17];
			cubestate[17] = cubestate[33];
			cubestate[33] = cubestate[36];
			cubestate[36] = tmp;
			//Edges of back layer
			tmp = cubestate[1];
			cubestate[1] = cubestate[14];
			cubestate[14] = cubestate[34];
			cubestate[34] = cubestate[39];
			cubestate[39] = tmp;
			break;
		}
		if(n > 1) {
			rotateFace(cubestate, face, n-1);
		}
	}
	
	public static String toFaceNotation(byte[] cubestate) {
		StringBuilder f = new StringBuilder();
		for(byte b : cubestate) {
			f.append(face(b));
		}
		return f.toString();
	}
	
	public static char face(byte b) {
		switch(b) {
		case 0:
			return 'U';
		case 1:
			return 'R';
		case 2:
			return 'F';
		case 3:
			return 'D';
		case 4:
			return 'L';
		case 5:
			return 'B';
		}
		return 'A';
	}
	
	public static String getSolveAlgorithm(byte[] cubestate) {
		String lline = null;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("./kociemba " + toFaceNotation(cubestate)).getInputStream()));
			String line;
			while((line = in.readLine()) != null) {
				lline = line;
			}
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lline;
	}
	
	public static void randomMoves(byte[] cubestate, int n) {
		Random r = new Random();
		for(int i = 0; i < n; ++i) {
			rotateFace(cubestate, r.nextInt(6), r.nextInt(4));
		}
	}
}
