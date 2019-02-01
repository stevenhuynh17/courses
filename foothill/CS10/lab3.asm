.data
	initial_prompt: 	.asciiz 	"INPUT NUMBER: "
	result_prompt: 		.asciiz 	"RESULT: "
	value: 			.word 		0
	answer: 		.word 		0

.text
li $v0, 4			# load immediate to print string
la $a0, initial_prompt		# load address into $a0 with initial prompt
syscall				# execute command

li $v0, 5			# load immediate to read integer into $v0
move $t0, $v0			# transfer value of $v0 into $t0
syscall				# execute command

sw $v0, value			# save word into $v0 with value

lw $a0, value			# load word into $a0 with value
jal factorial			# call factorial function
sw $v0, answer			# save word into $v0 with answer

li $v0, 4			# load immediate to print string
la $a0, result_prompt		# load address into $a0 with result prompt
syscall				# execute command

li $v0, 1			# load immediate to print integer
lw $a0, answer			# load word into $a0 with answer
syscall				# execute command

li $v0, 10			# end the program
syscall				# execute command

factorial:
subu $sp, $sp, 8		# subtract stack pointer by 8
sw $ra, ($sp)			# store word into $ra with stack pointer
sw $s0, 4($sp)			# store wrod into $s0 with 1st position in stack pointer
li $v0, 1			# load into $v0 value of 1
beq $a0, 0, basecase		# if $a0 and 0 are equal, execute basecase
move $s0, $a0			# move into $s0 with value of $a0		
sub $a0, $a0, 1			# subtract $a0 by 1 into $a0
jal factorial			# go back to factorial function
mul $v0, $s0, $v0		# multiply $s0 and $v0 into $v0

basecase: 
lw $ra, ($sp)			# load word of stack pointer into $ra
lw $s0, 4($sp)			# load word of stack pointer position 1 into $s0
addu $sp, $sp, 8		# add 8 into $sp
jr $ra				# return back to $ra