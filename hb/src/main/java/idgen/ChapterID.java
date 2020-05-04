package idgen;

import java.io.Serializable;

public class ChapterID implements Serializable {
	private int bookId, chapterNo;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getChapterNo() {
		return chapterNo;
	}

	public void setChapterNo(int chapterNo) {
		this.chapterNo = chapterNo;
	}

	public ChapterID(int bookId, int chapterNo) {
		this.bookId = bookId;
		this.chapterNo = chapterNo;
	}

	public boolean equals(Object obj) {
		ChapterID other = (ChapterID) obj;
		return this.bookId == other.bookId && this.chapterNo == other.chapterNo;
	}

	public int hashCode() {
		// code
		return this.bookId + this.chapterNo;
	}
}
