# Product Requirements Document (PRD): mad calc

## 1. Overview

mad calc is a command-line calculator designed for primary school students (ages 6-12). Its purpose is to provide a simple, distraction-free tool for basic arithmetic. A key reason for the CLI approach is to gently introduce students to the command line, helping them become familiar with a fundamental tool in the tech world, thus adding a layer of technical literacy to its educational value.

## 2. Problem Statement

Primary school students lack access to simple, age-appropriate digital calculators. Existing solutions are often too complex or not designed for educational use, hindering math learning and confidence. There is a need for a focused, child-friendly calculator tool.

## 3. Goals & Success Metrics

- Deliver a working CLI calculator in 10 days
- Achieve adoption in at least one classroom or educational setting
- User satisfaction (teacher/student feedback)
- No critical bugs reported in classroom use

## 4. Target Users

- **Primary:** Children aged 6-12 learning basic math
- **Secondary:** Teachers introducing digital tools in class

## 5. Requirements

### 5.1 Functional Requirements

- Basic arithmetic operations: add, subtract, multiply, divide
- Support for parentheses in mathematical expressions (e.g., 2 * (3 + 4))
- Square root, power of two, and cube functions
- Simple CLI interface: minimal text, easy prompts
- Clear error messages for invalid input

### 5.2 Non-Functional Requirements

- Fast startup and instant response
- Cross-platform (macOS, Windows, Linux)
- No data collection; safe for children

### 5.3 Out of Scope (MVP)

- Graphical user interface

## 6. User Stories

- As a student, I want to perform basic math operations easily so I can complete my homework.
- As a teacher, I want a simple calculator tool I can recommend to my students.

## 7. MVP Success Criteria

- A primary school student can use the calculator independently to solve basic math problems.
- A teacher can recommend it for classroom use.

## 8. Technical Considerations

- Java CLI application
- No database or external dependencies
- Monolithic project structure

## 9. Constraints & Assumptions

- Must use Java, CLI only
- Timeline: 10 days
- Students have access to a computer with Java installed
- Teachers are willing to introduce CLI tools in class

## 10. Risks & Open Questions

- **Adoption Risk:** CLI may be intimidating for some users
- **Technical Risk:** Compatibility across OSes
- How will feedback from students/teachers be collected?
- Are there accessibility needs to consider?

## 11. Future Vision

- Support for fractions and decimals
- Simple math games or quizzes
- Multi-language support
- Mobile/web versions

## 12. Next Steps

1. Finalize requirements with stakeholders
2. Set up Java project structure
3. Develop core CLI calculator features
4. Test with sample users (students/teachers)
5. Collect feedback and iterate
