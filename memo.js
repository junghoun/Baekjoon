$(function () {
	// 메모 추가 버튼 클릭시 화면에 메모를 보여주기 : createBtn
	$("#createBtn").click(function() {
		new Memo().create();
		
	});
});
 

function Memo() {
	this.$note = null;
}

Memo.prototype.create = function() {
	console.log("create");
	
	var $note = $(
			`
			<div class="memo-note">
				<div class="memo-bar">
				<span class="glyphicon glyphicon-chevron-up" aria-hidden="true"></span>
				<span class="glyphicon glyphicon-pushpin" aria-hidden="true"></span>
				<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
				</div>
				<div class="memo-edit">
				<textarea class="memo-edit-area"></textarea>
				</div>
			</div>
			`
	);
	
	$note.appendTo($(".memo-area"));
	
	this.$note = $note;
	this.drag();
	
	var that = this;
	
	$note.find(".glyphicon-chevron-up").click(function () {
		that.display();
	});
	$note.find(".glyphicon-pushpin").click(function () {
		that.fix();
	});
	$note.find(".glyphicon-trash").click(function () {
		that.del();
	});
};

Memo.prototype.drag = function() {
	this.$note.draggable();
};

Memo.prototype.display = function() {
	console.log("display");
};

Memo.prototype.fix = function() {
	$note.find(".glyphicon-pushpin").toggleClass("choice");
};

Memo.prototype.del = function() {
	this.$note.remove();
};