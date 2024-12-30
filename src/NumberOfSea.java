import java.util.*;

public class NumberOfSea {
    static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return age == person.age && Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }
    }
    public static void main(String[] args) {
        HashSet<Person> set = new HashSet<>();
        Person p1 = new Person("Alice", 30);
        Person p2 = new Person("Alice", 30);
        set.add(p1);
        System.out.println(set);
        int[][] grid1 = {
//                {0, 1, 1, 0, 0, 1},
//                {0, 1, 0, 1, 0, 0},
//                {1, 1, 0, 1, 1, 1},
//                {0, 0, 1, 1, 1, 1},
//                {1, 0, 1, 1, 0, 0}
                {0, 2, 1, 0},
                {0, 1, 0, 1},
                {1, 1, 0, 1},
                {0, 1 , 0 ,1}
        };
        System.out.println("Test case 1: " + pondSizes(grid1));
    }

    public static List<Integer> pondSizes(int[][] land) {
        List<Integer> pondSizes = new ArrayList<>();
        //your code here
        int[] dRow = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dCol = {-1, 0, 1, -1, 1, -1, 0, 1};
        int rows = land.length;
        int cols = land[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (land[i][j] == 0 && !visited[i][j]) {
                    int pondSize = 0;
                    List<int[]> stack = new ArrayList<>();
                    stack.add(new int[]{i, j});
                    while (!stack.isEmpty()) {
                        int[] cell = stack.remove(stack.size() - 1);
                        int row = cell[0];
                        int col = cell[1];
                        if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col] || land[row][col] != 0) {
                            continue;
                        }
                        visited[row][col] = true;
                        pondSize++;
                        for (int d = 0; d < 8; d++) {
                            int newRow = row + dRow[d];
                            int newCol = col + dCol[d];
                            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && !visited[newRow][newCol] && land[newRow][newCol] == 0)
                                stack.add(new int[]{newRow, newCol});
                        }
                    }
                    if(pondSize > 0){
                        pondSizes.add(pondSize);
                    }
                }
            }
        }
        return pondSizes;
    }
}