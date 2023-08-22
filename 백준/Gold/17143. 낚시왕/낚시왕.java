import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	static class Shark {
		int x, y, velocity, dir, size;

		Shark(int x, int y, int velocity, int dir, int size) {
			this.x = x;
			this.y = y;
			this.velocity = velocity;
			this.dir = dir;
			this.size = size;
		}
	}

	static int R, C, M, ans;
	static int xx, yy, s, d, z;
	static Shark map[][], newMap[][];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static HashSet<Shark> hset = new HashSet<>();
	static ArrayDeque<Shark> removeShark = new ArrayDeque<>();;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new Shark[R + 1][C + 1];
//		newMap = new Shark[R+1][C+1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			xx = Integer.parseInt(st.nextToken());
			yy = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			if (d == 1 || d == 2)
				s %= (2 * R - 2);
			else
				s %= (2 * C - 2);
			map[xx][yy] = new Shark(xx, yy, s, d, z);
			hset.add(map[xx][yy]);

		}
		for (int i = 1; i < C + 1; i++) {
//			System.out.println(i);
			ans += fishing(i);
			moveShark();
//			System.out.println(ans);
		}
		System.out.println(ans);
	}

	static int fishing(int c) {
		for (int r = 1; r < R + 1; r++) {
			if (map[r][c] != null) {
				int tmp = map[r][c].size;
				hset.remove(map[r][c]);
				map[r][c] = null;
				return tmp;
			}
		}
		return 0;
	}

	static void moveShark() {
//		deepCopy(map, newMap);
		newMap = new Shark[R + 1][C + 1];
//		for (Shark shark : hset) {
//			map[shark.x][shark.y]=null;
//		}
		for (Shark shark : hset) {
			if (shark.dir == 1) {
				if (shark.velocity <= shark.x - 1) {
					shark.x -= shark.velocity;
				} else if (shark.velocity <= R + shark.x - 2) {
					shark.x = shark.velocity - shark.x + 2;
					shark.dir = 2;
				} else {
					shark.x = (2 * R - 2) - shark.velocity + shark.x;
				}
			} else if (shark.dir == 2) {
				if (shark.velocity <= R - shark.x) {
					shark.x += shark.velocity;
				} else if (shark.velocity <= 2 * R - shark.x - 1) {
					shark.x = 2 * R - shark.velocity - shark.x;
					shark.dir = 1;
				} else {
					shark.x = shark.velocity - (2 * R - 2) + shark.x;
				}
			} else if (shark.dir == 3) {
				if (shark.velocity <= C - shark.y) {
					shark.y += shark.velocity;
				} else if (shark.velocity <= 2 * C - shark.y - 1) {
					shark.y = 2 * C - shark.velocity - shark.y;
					shark.dir = 4;
				} else {
					shark.y = shark.velocity - (2 * C - 2) + shark.y;
				}
			} else if (shark.dir == 4) {
				if (shark.velocity <= shark.y - 1) {
					shark.y -= shark.velocity;
				} else if (shark.velocity <= C + shark.y - 2) {
					shark.y = shark.velocity - shark.y + 2;
					shark.dir = 3;
				} else {
					shark.y = (2 * C - 2) - shark.velocity + shark.y;
				}
			}
			if (newMap[shark.x][shark.y] == null)
				newMap[shark.x][shark.y] = shark;
			else if (newMap[shark.x][shark.y].size < shark.size) {
				removeShark.add(newMap[shark.x][shark.y]);
				newMap[shark.x][shark.y] = shark;
			} else {
				removeShark.add(shark);
			}
			
		}
		for (int i = 0, end =removeShark.size(); i < end; i++) {
			hset.remove(removeShark.poll());
		}
		deepCopy(newMap, map);
	}

	static void deepCopy(Shark[][] map1, Shark[][] map2) {
		for (int i = 0; i < R + 1; i++) {
			map2[i] = Arrays.copyOf(map1[i], C + 1);
		}
	}

}