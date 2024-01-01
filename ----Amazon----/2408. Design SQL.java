/*
 * medium
 * time:
 * Constructor-O(N), where N is the number of tables being created. This is due to the loop that iterates over the names list to create Table objects.
 * insertRow/deleteRow/selectCell-O(1) on average, assuming a good hash function for HashMap. This is because accessing a Table by name and inserting a row into the HashMap typically takes constant time.
 * Overall space complexity: O(T * R), where T is the number of tables and R is the average number of rows in each table. This is because the tables HashMap stores T Table objects, and each Table object's rows HashMap stores R rows on average.
 * Constructor-O(T), where T is the number of tables being created. This is due to the allocation of space for T Table objects.
 * insertRow-O(R), where R is the number of rows in the table. This is due to the allocation of space for the new row in the rows HashMap.
 * deleteRow-O(1). This is because deleting a row from the rows HashMap does not significantly affect the overall space usage.
 * selectCell-O(1). This is because retrieving a cell value does not allocate any additional space.
 */

class SQL {
    HashMap<String, Table> tables;

    public SQL(List<String> names, List<Integer> columns) {
        tables = new HashMap<>();

        for (int i = 0; i < names.size(); i++) {
            tables.put(names.get(i), new Table(columns.get(i)));
        }
    }

    public void insertRow(String name, List<String> row) {
        tables.get(name).insert(row);
    }

    public void deleteRow(String name, int rowId) {
        tables.get(name).delete(rowId);
    }

    public String selectCell(String name, int rowId, int columnId) {
        return tables.get(name).getCell(rowId, columnId);
    }

    class Table {
        int id;
        int columns;
        HashMap<Integer, List<String>> rows;

        public Table(int columns) {
            this.columns = columns;
            rows = new HashMap<>();
        }

        public void insert(List<String> row) {
            rows.put(++id, row);
        }

        public void delete(int rowId) {
            rows.remove(rowId);
        }

        public String getCell(int rowId, int columnId) {
            return rows.get(rowId).get(columnId - 1);
        }
    }
}

/**
 * Your SQL object will be instantiated and called as such:
 * SQL obj = new SQL(names, columns);
 * obj.insertRow(name,row);
 * obj.deleteRow(name,rowId);
 * String param_3 = obj.selectCell(name,rowId,columnId);
 */