\ProvidesClass{tossupbonus}[2017/06/22 version 1.0]
\NeedsTeXFormat{LaTeX2e}
\DeclareOption*{\PassOptionsToClass{\CurrentOption}{article}}
\ProcessOptions\relax
\LoadClass{article}

\RequirePackage[T1]{fontenc}
\RequirePackage[none]{hyphenat}           % prevent hyphenation
\RequirePackage{lmodern}
\RequirePackage{cmap}
\RequirePackage{fixltx2e}
\RequirePackage{microtype}                % makes things pretty
\RequirePackage[normalem]{ulem}           % makes \uline function give identical underlines to text with and without descenders
	\setlength{\ULdepth}{1.15pt}          % adjusts underline position
\RequirePackage[top=0.5in, bottom=1in, left=1in, right=1in]{geometry}
\RequirePackage{amsmath}                  % to get \nobreakdash
\RequirePackage{amsbsy}                   % to get \boldsymbol
\RequirePackage{tipa}                     % additional accents
\RequirePackage{graphicx}                 % for including the arrow graphics
\RequirePackage{array}
	\newcolumntype{x}[1]{>{\raggedright\hspace{0pt}}p{#1}} % Left-aligned multiline table cell
	\newcolumntype{y}[1]{>{\centering\hspace{0pt}}p{#1}} % Centered multiline table cell
	\newcolumntype{z}[1]{>{\raggedleft\hspace{0pt}}p{#1}} % Right-aligned multiline table cell
\RequirePackage{xcolor}
\RequirePackage{fancyhdr}                 % allows setting up the footer
	\pagestyle{fancy}
	\pagestyle{plain} % get rid of default page number
	\rfoot{\thepage}
\RequirePackage[
	colorlinks,
	linkcolor=black,
	urlcolor=black,
	citecolor=black,
	linktoc=none,
	bookmarks=false,
	bookmarksopen=false,
				]{hyperref}

\RequirePackage{setspace}
	\AtBeginDocument{\begin{spacing}{1.15}}
	\AtEndDocument{\end{spacing}}

\raggedright \raggedbottom

\setlength\parindent{0pt}
\setlength\parskip{0pt}
\setlength\tabcolsep{0.1in}
\renewcommand\arraystretch{1.1}
\newlength{\interquestionskip} \setlength\interquestionskip{0.4in}

\RequirePackage{mathspec} % Includes fontspec
%	\setmainfont[Ligatures=TeX]{TeX Gyre Termes} % Similar to Times New Roman
%	\setmathrm[Ligatures=TeX]{TeX Gyre Termes}
%	\setmathfont(Digits,Latin){TeX Gyre Termes}
%	\setmathfont[bold-style=TeX]{TG Termes Math}
%	\setsansfont[Ligatures=TeX]{TeX Gyre Heros} % Similar to Helvetica/Arial

\newcommand{\sectionHeader}[3]{
	\textbf{\fontsize{16pt}{18pt}\selectfont #1 -- #2} % Packet set name, then packet name
	
	\textbf{#3} % "Tossups" or "Bonuses"
	
	\fontsize{12pt}{15pt} \selectfont
	
	\vspace*{\interquestionskip}
}

\newcommand{\tossup}[3]{
	\begin{samepage}
		\begin{minipage}{\textwidth}
			\textbf{#1} #2 % Number, then question
			
			Answer: #3
		\end{minipage}
	\end{samepage}
	
	\vspace*{\interquestionskip}
}

\newcommand{\bonus}[8]{
	\begin{samepage}
		\begin{minipage}{\textwidth}
			\textbf{#1} #2 % Number, then intro
			
			A. #3
			
			Answer: #4
			
			B. #5
			
			Answer: #6
			
			C. #7
			
			Answer: #8
		\end{minipage}
	\end{samepage}
	
	\vspace*{\interquestionskip}
}

\newcommand{\pg}[2]{\textcolor{purple}{#1 \penalty 10000 [#2]}}
\newcommand{\syl}{$\cdot$}                 % Enclose in {}, i.e. "Syl{\syl}la{\syl}ble", for the spacing to look right.

\newcommand{\req}[1]{\textbf{\uline{#1}}}
