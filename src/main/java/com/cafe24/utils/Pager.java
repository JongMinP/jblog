package com.cafe24.utils;

public class Pager {

	private int startPageNum; // 시작번호
	private int endPageNum; // 끝 번호
	private int currentPageNum; // 현재 페이지 번호
	private int totalCount; // 총 갯수

	private boolean prev; // 왼쪽 화살표 유무
	private boolean next; // 오른쪽 화살표 유무

	private int pagingNum; // 몇개씩 나눌지
	private int pageNumCount; // 하단의 번호 몇개 씩 할지

	private int pageBlock; // 화살표 누른 다음 보여지는 단락

	public Pager() {
		this.pagingNum = 5;
		this.pageNumCount = 5;
		this.prev = false;
		this.next = false;
		this.startPageNum = 1;
		this.pageBlock = 1;
		this.endPageNum = pageBlock * pagingNum;
	}

	public int getStartPageNum() {
		return startPageNum;
	}

	public void setStartPageNum(int startPageNum) {
		this.startPageNum = startPageNum;
	}

	public int getEndPageNum() {
		return endPageNum;
	}

	public void setEndPageNum(int endPageNum) {
		this.endPageNum = endPageNum;
	}

	public int getCurrentPageNum() {
		return currentPageNum;
	}

	public void setCurrentPageNum(int currentPageNum) {
		this.currentPageNum = currentPageNum;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public boolean isPrev() {

		if (startPageNum > 1) {
			return true;
		}

		return false;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {

		if (endPageNum * pageNumCount >= totalCount) {
			return false;
		}
		return true;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getPagingNum() {
		return pagingNum;
	}

	public void setPagingNum(int pagingNum) {
		this.pagingNum = pagingNum;
	}

	public int getPageBlock() {
		
		startPageNum = pageBlock * pagingNum  - (pagingNum -1);
		
		return pageBlock;
	}

	public void setPageBlock(int pageBlock) {
		this.pageBlock = pageBlock;
	}

	public int getPageNumCount() {
		return pageNumCount;
	}

	public void setPageNumCount(int pageNumCount) {
		this.pageNumCount = pageNumCount;
	}

	@Override
	public String toString() {
		return "Pager [startPageNum=" + startPageNum + ", endPageNum=" + endPageNum + ", currentPageNum="
				+ currentPageNum + ", totalCount=" + totalCount + ", prev=" + prev + ", next=" + next + ", pageingNum="
				+ pagingNum + ", pageNumCount=" + pageNumCount + ", pageBlock=" + pageBlock + "]";
	}

}
