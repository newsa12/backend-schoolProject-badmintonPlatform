# Badminton Matching Service
Implementing a Badminton Matching Platform for School Assignments

# git clone
git clone https://github.com/newsa12/backend-schoolProject-badmintonPlatform.git

cd backend-schoolProject-badmintonPlatform

## 👥 Devide Up
- **KHJ**: User/Skill module
- **MCH**: Court/Reservation module
- **JMS**: Matching module
- **PCY**: PlayRecord/Rating module  
- **PSH**: Chat/Community module

## 🌿 Git Branch Strategy
- `main` : Stable code that is always buildable and executable  
- `feature/{module_name}` : Feature development branch 
- `bugfix/{issue number}` : bug fix branch

## 🚀 Development Start Order
1. `git pull origin main`  
2. `git checkout -b feature/{your-module}`  
3. 개발 → `git add .` → `git commit -m "[{모듈명}] 작업 내용"`  
4. `git push origin feature/{your-module}`  
5. GitHub에서 PR 생성 → 리뷰 → Merge → `git checkout main && git pull`
