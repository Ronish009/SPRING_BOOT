This command is used when you have to reset to last commit but we have one commit that we laready commited.
Step 1:
$ EMPTY_TREE=$(git hash-object -t tree /dev/null)
 
EMPTY_COMMIT=$(git commit-tree $EMPTY_TREE -m "temp")
Step 2: 
$ git reset --soft $EMPTY_COMMIT


=========================================

echo "# SPRING_BOOT" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/Ronish009/SPRING_BOOT.git
git push -u origin main


echo "# MCP" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/Ronish009/MCP.git
git push -u origin main



echo "# Other_Project" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/Ronish009/Other_Project.git
git push -u origin main


git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/Ronish009/Other_Project.git
git push -u origin main
