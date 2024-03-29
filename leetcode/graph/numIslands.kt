class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        fun dfs(row: Int, col: Int) {
            if (row !in 0 until grid.size 
                || col !in 0 until grid[0].size
                || grid[row][col] != '1') return
            
            grid[row][col] = '#'
            
            dfs(row-1, col)
            dfs(row, col-1)
            dfs(row, col+1)
            dfs(row+1, col)
        }
        
        var answer = 0
        for (r in 0 until grid.size) {
            for (c in 0 until grid[0].size) {
                if (grid[r][c] == '1') {
                    dfs(r, c)
                    answer += 1
                }
            }
        }
        
        return answer
    }
}

//kotlin 2d array
//Array(row) { Array<Any?>(col) {null} }
//Array(height) { arrayOfNulls<Land?>(width) }


class Solution2 {
    fun numIslands(grid: Array<CharArray>): Int {
        val visited = Array<BooleanArray>(grid.size) { BooleanArray(grid[0].size) }
        
        fun dfs(row: Int, col: Int) {
            if (row !in 0 until grid.size
               || col !in 0 until grid[0].size
               || grid[row][col] != '1'
               || visited[row][col]) return
            
            visited[row][col] = true
            
            dfs(row-1, col)
            dfs(row+1, col)
            dfs(row, col-1)
            dfs(row, col+1)
        }
        
        var answer = 0
        for (r in 0 until grid.size) {
            for (c in 0 until grid[0].size) {
                if (grid[r][c] == '1' && visited[r][c] == false){
                    dfs(r, c)
                    answer += 1
                }
            }
        }
        
        return answer
    }
}
