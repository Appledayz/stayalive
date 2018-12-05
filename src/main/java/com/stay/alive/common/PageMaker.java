package com.stay.alive.common;

public class PageMaker {
	private int currentPage; // 현재 페이지번호
    private int rowPerPage; // 한 페이지에 보여줄 행
    private int pagePerBlock;// 블록당 보여질 페이지의 수
    private int allCount; // 전체 게시물 개수
    private int startRow; // 한 페이지에 시작하는 행
    private int lastPage; // 전체 페이지 중 마지막 페이지번호
    private int currentBlock; // 현재 페이지 블록
    private int lastBlock; // 마지막 페이지 블록
    private int startPage; // 현재 페이지 블록의 시작페이지
    private int endPage; // 현재 페이지 블록의 마지막페이지
    private boolean prevPage; // 이전페이지 화살표
    private boolean nextPage; // 다음페이지 화살표
    
    public int getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    public int getRowPerPage() {
        return rowPerPage;
    }
    public void setRowPerPage(int rowPerPage) {
        this.rowPerPage = rowPerPage;
    }
    public int getPagePerBlock() {
        return pagePerBlock;
    }
    public void setPagePerBlock(int pagePerBlock) {
        this.pagePerBlock = pagePerBlock;
    }
    public int getAllCount() {
        return allCount;
    }
    public void setAllCount(int allCount) {
        this.allCount = allCount;
    }
    public int getStartRow() {
        return startRow;
    }
    // 현재페이지와 한 페이지에 보여줄 행의 수를 이용해 한 페이지에 시작하는 행을 구한다.
    public void setStartRow() {
        int startRow = (getCurrentPage() - 1) * getRowPerPage(); // 현재페이지가 1페이지면 0행부터, 2페이지면 10행부터, 3페이지면 20행부터...
        this.startRow = startRow;
    }
    public int getLastPage() {
        return lastPage;
    }
    // 마지막 페이지(전체 페이지)를 구해서 set한다. 전체게시글의 갯수 / 한페이지에 보여줄행
    // 전체게시글의 갯수 나누기 한페이지에 보여줄행이 0보다 크다면 +1 해줌으로써 마지막 페이지를 구한다.
    public void setLastPage() {
        int lastPage = getAllCount() / getRowPerPage();
        if(getAllCount() % getRowPerPage() != 0) {
            lastPage++;
        }
        this.lastPage = lastPage;
    }
    public int getCurrentBlock() {
        return currentBlock;
    }
    // 현재 페이지와 블록당 보여질 페이지의 수를 이용해 현재 페이지 블록을 구한다.
    public void setCurrentBlock() {
        int currentBlock = getCurrentPage() / getPagePerBlock();
        if(getCurrentPage() % getPagePerBlock() != 0) {
            currentBlock++;
        }
        this.currentBlock = currentBlock;
    }
    public int getLastBlock() {
        return lastBlock;
    }
    // 전체 게시물 개수와 블록당 보여질 페이지의 수와 한 페이지에 보여줄 행의 수을 이용해 마지막 페이지 블록을 구한다.
    public void setLastBlock() {
        int lastBlock = getAllCount() / (getPagePerBlock() * getRowPerPage());
        if(getAllCount() % (getPagePerBlock() * getRowPerPage()) != 0) {
            lastBlock++;
        }
        this.lastBlock = lastBlock;
    }
    public int getStartPage() {
        return startPage;
    }
    // 현재 페이지 블록과 블록당 보여질 페이지의 개수를 이용하여 현재 페이지 블록의 시작 페이지를 구한다. ex) "1"2345678910
    public void setStartPage() {
        int startPage = (getCurrentBlock() * getPagePerBlock()) - (getPagePerBlock() - 1);
        this.startPage = startPage;
    }
    public int getEndPage() {
        return endPage;
    }
    // 현재 페이지 블록과 마지막 페이지 블록이 같을 때와 다를 때 각각 마지막 페이지가 달라지는 점을 이용하여 마지막페이지를 구한다. ex) 123456789'10'
    public void setEndPage() {
        int endPage = 0;
        if (getLastBlock() == getCurrentBlock()) {
            endPage = getLastPage();
        } else {
            endPage = getStartPage() + (getPagePerBlock() - 1);
        }
        this.endPage = endPage;
    }
    public boolean isPrevPage() {
        return prevPage;
    }
    public void setPrevPage(boolean prevPage) {
        this.prevPage = prevPage;
    }
    public boolean isNextPage() {
        return nextPage;
    }
    public void setNextPage(boolean nextPage) {
        this.nextPage = nextPage;
    }
}
