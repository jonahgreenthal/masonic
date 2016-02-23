\ProvidesClass{masonicbowl}[2015/04/23 version 1.0]
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
				
\raggedright \raggedbottom

\setlength\parindent{0pt}
\setlength\parskip{0pt}
\setlength\tabcolsep{0.1in}
\renewcommand\arraystretch{1.1}
\newlength{\interquestionskip} \setlength\interquestionskip{0.4in}

\RequirePackage{mathspec} % Includes fontspec
	\setmainfont[Ligatures=TeX]{TeX Gyre Termes} % Similar to Times New Roman
	\setmathrm[Ligatures=TeX]{TeX Gyre Termes}
	% \setmathfont(Digits,Latin){TeX Gyre Termes}
	\setmathfont[bold-style=TeX]{TG Termes Math}
	\setsansfont[Ligatures=TeX]{TeX Gyre Heros} % Similar to Helvetica/Arial

\newcommand{\header}[4]{
	\begin{minipage}{0.65in}
		\vspace*{30pt}
		\includegraphics[keepaspectratio=true,width=0.56in]{"masonic-square-and-compass"}
	\end{minipage}
	\begin{minipage}[t]{3.1in}
		\fontsize{16pt}{18pt} \selectfont
		Illinois Masonic Academic Bowl \\
		#1 % e.g. "2015 Sectional Tournament"
	\end{minipage}
	\hfill
	\begin{minipage}[t]{2.4in}
		\fontsize{16pt}{18pt} \selectfont
		\raggedleft
		\textsf{\textbf{#2}} \\ % e.g. "Round #1"
		\textsf{\textbf{#3}} \\ % e.g. "1st Section"
		\textsf{\textbf{#4}} % e.g. "Toss-Up Questions"
	\end{minipage}
	
	\vspace*{\interquestionskip}
}

\newcommand{\tossup}[4]{
	\fontsize{16pt}{18pt} \selectfont
	\textsf{\textbf{#1}}
	
	\hfill \fontsize{14pt}{18pt} \selectfont \textsf{\textit{#2}} % e.g. "Question #1: Math - Math Concepts" and "10 points" respectively
	
	\fontsize{13pt}{16pt} \selectfont
	\begin{tabular}{| x{4in} | x{2.1in} |}
		\hline
		#3 % Question
		&
		#4 % Answer
		\tabularnewline[8pt]
		\hline
	\end{tabular}
}

\newcommand{\teamquestion}[9]{
	\fontsize{16pt}{18pt} \selectfont
	\textsf{\textbf{#1}}
	
	\hfill \fontsize{14pt}{18pt} \selectfont \textsf{\textit{#2}} % e.g. "Question #7: Science - Biology" and "10 points per part" respectively
	
	\fontsize{13pt}{16pt} \selectfont
	\begin{tabular}{| y{0.2in} | x{3.7in} | x{2.1in} |}
		\cline{1-2}
		\multicolumn{2}{|x{3.9in}|}{#3} & \multicolumn{1}{c}{} \tabularnewline[8pt] % Intro
		\hline
		\textbf{1} & #4 & #5 \tabularnewline[8pt] % First part and answer
		\hline
		\textbf{2} & #6 & #7 \tabularnewline[8pt] % Second part and answer
		\hline
		\textbf{3} & #8 & #9 \tabularnewline[8pt] % Third part and answer
		\hline
	\end{tabular}
}

\newcommand{\questionpage}[6]{
	\header{#1}{#2}{#3}{#4}
	
	#5 % should be a \teamquestion call
	
	\vspace*{\interquestionskip}
	
	#6 % should be a \teamquestion call
}

% \newcommand{\pg}[2]{\mbox{#1~\mbox{\textcolor{purple}{[#2]}}}}
\newcommand{\pg}[2]{\textcolor{purple}{#1 \penalty 10000 [#2]}}
\newcommand{\syl}{$\cdot$}                 % Enclose in {}, i.e. "Syl{\syl}la{\syl}ble", for the spacing to look right.

\newcommand{\req}[1]{\textbf{\uline{#1}}}
